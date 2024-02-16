package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.List;



/**
 * Класс для хранения данных каталога.
 */
@JacksonXmlRootElement(localName = "CATALOG")
public class Catalog implements Serializable {

    public Catalog() {
    }

    public Catalog(List<Cd> cds) {
        this.cds = cds;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CD")

    private List<Cd> cds;

    public void setCds(List<Cd> cds) {
        this.cds = cds;
    }

    public List<Cd> getCds() {
        return cds;
    }

    @Override
    public String toString() {
        return "Catalog{"
                + "cds=" + cds
                + '}';
    }
}
