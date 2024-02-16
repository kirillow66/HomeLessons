package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных об артистах в рамках страны.
 */
public class Country implements Serializable {

    public Country(String name, List<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Artist")
    private List<Artist> artists = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Country{"
                + "name='" + name + '\''
                + ", artists=" + artists
                + '}';
    }
}
