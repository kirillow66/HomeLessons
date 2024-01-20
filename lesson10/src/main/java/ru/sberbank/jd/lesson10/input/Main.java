package ru.sberbank.jd.lesson10.input;


import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import ru.sberbank.jd.lesson10.output.Album;
import ru.sberbank.jd.lesson10.output.Artist;
import ru.sberbank.jd.lesson10.output.Country;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Main class.
 */
public class Main implements Serializable {

    /**
     * Main method. Compiles a register of performers by country and publishes it.
     *
     * @param args - args.
     * @throws IOException - input/output exception.
     */
    public static void main(String[] args) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Catalog catalog = mapper.readValue(new File("lesson10/src/main/resources/input/cd_catalog.xml"), Catalog.class);
        Map<String, Map<String, List<Album>>> albumByCountryAndArtist =
                catalog.getCds().stream().collect(groupingBy(Cd::getCountry,
                        groupingBy(Cd::getArtist,
                                mapping((Cd one) -> new Album(one.getTitle(), one.getYear()),
                                        toList()))));
        List<Country> countries =
                albumByCountryAndArtist.entrySet()
                        .stream()
                        .map((two) -> new Country(two.getKey(),
                                two.getValue()
                                        .entrySet()
                                        .stream()
                                        .map((ll) -> new Artist(ll.getKey(), ll.getValue()))
                                        .collect(toList())))
                        .collect(toList());
        System.out.println(countries);
        Registry one = new Registry(countries);
        one.setCountryCount(countries.stream().mapToInt(c -> 1).sum());
        mapper.writeValue(new File("lesson10/src/main/resources/output/artist_by_country.xml"), one);

        FileOutputStream fileOutputStream = new FileOutputStream(
                "lesson10/src/main/resources/output/artist_by_country.serialized");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(one);
        objectOutputStream.close();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        objectMapper.writeValue(new File("lesson10/src/main/resources/output/artist_by_country.json"), one);

    }

}
