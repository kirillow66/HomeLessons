package ru.sberbank.jd.lesson10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.w3c.dom.css.Counter;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.input.Cd;

public class MainTest implements Serializable {

    @Test
    public void jsonTest() throws JsonProcessingException {
        Cd cd1 = new Cd("Empire Burlesque", "Bob Dylan", "USA", "Columbia", 10.90, 1985);
        Cd cd2 = new Cd("Hide your heart", "Bonnie Tyler", "UK", "CBS Records", 9.90, 1988);
        List<Cd> cds = new ArrayList<>();
        cds.add(cd1);
        cds.add(cd2);
        Catalog collection = new Catalog(cds);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Catalog cdsJSON = objectMapper.readValue(new File("src/test/resources/test.json"), Catalog.class);
            assertEquals(collection.toString(), cdsJSON.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xmlTest() throws IOException {
        Cd cd1 = new Cd("Empire Burlesque", "Bob Dylan", "USA", "Columbia", 10.90, 1985);
        Cd cd2 = new Cd("Hide your heart", "Bonnie Tyler", "UK", "CBS Records", 9.90, 1988);
        List<Cd> cds = new ArrayList<>();
        cds.add(cd1);
        cds.add(cd2);
        Catalog collection = new Catalog(cds);
        XmlMapper mapper = new XmlMapper();
        Catalog catalog = mapper.readValue(new File("src/test/resources/test.xml"), Catalog.class);
        assertEquals(collection.toString(), catalog.toString());
    }

    @Test
    public void serializationTest() throws IOException, ClassNotFoundException {
        Cd cd1 = new Cd("Empire Burlesque", "Bob Dylan", "USA", "Columbia", 10.90, 1985);
        Cd cd2 = new Cd("Hide your heart", "Bonnie Tyler", "UK", "CBS Records", 9.90, 1988);
        List<Cd> cds = new ArrayList<>();
        cds.add(cd1);
        cds.add(cd2);
        Catalog collection = new Catalog(cds);
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/test.serialized");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Catalog catalog = (Catalog) objectInputStream.readObject();
        objectInputStream.close();
        assertEquals(collection.toString(), catalog.toString());
    }


}