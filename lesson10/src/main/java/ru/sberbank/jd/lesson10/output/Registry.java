package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных по странам.
 */
@JacksonXmlRootElement(localName = "ArtistRegistry")
public class Registry implements Serializable {

    public Registry(List<Country> countries) {
        this.countries = countries;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
    private List<Country> countries = new ArrayList<>();

    @JacksonXmlProperty(isAttribute = true)
    private int countryCount;

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Registry{"
                + "countries=" + countries
                + '}';
    }
}
