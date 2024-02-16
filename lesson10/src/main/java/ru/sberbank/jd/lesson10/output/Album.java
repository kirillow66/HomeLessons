package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;

/**
 * Класс для хранения данных о альбоме.
 */
public class Album implements Serializable {

    public Album(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private int year;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Album{"
                + "name='" + name + '\''
                + ", year=" + year
                + '}';
    }
}
