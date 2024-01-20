package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;


/**
 * Класс для хранения данных о диске.
 */
@JacksonXmlRootElement(localName = "CD")
public class Cd implements Serializable {

    public Cd() {
    }

    /**
     * Конструктор класса.
     *
     * @param title   - title of album
     * @param artist  - name artist
     * @param country - country of artist
     * @param company - the company that released the album
     * @param price   - price of album
     * @param year    - the year of the album's release
     */
    public Cd(String title, String artist, String country, String company, double price, int year) {
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.company = company;
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cd{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + ", country='" + country + '\''
                + ", company='" + company + '\'' + ", price=" + price + ", year=" + year + '}';
    }

    @JacksonXmlProperty(localName = "TITLE")
    private String title;
    @JacksonXmlProperty(localName = "ARTIST")
    private String artist;
    @JacksonXmlProperty(localName = "COUNTRY")
    private String country;
    @JacksonXmlProperty(localName = "COMPANY")
    private String company;
    @JacksonXmlProperty(localName = "PRICE")
    private double price;
    @JacksonXmlProperty(localName = "YEAR")
    private int year;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
