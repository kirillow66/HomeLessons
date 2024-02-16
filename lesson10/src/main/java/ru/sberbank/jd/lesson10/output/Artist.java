package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных о исполнителе.
 */
public class Artist implements Serializable {

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Album")
    private List<Album> albums = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{"
                + "name='" + name + '\''
                + ", albums=" + albums
                + '}';
    }
}
