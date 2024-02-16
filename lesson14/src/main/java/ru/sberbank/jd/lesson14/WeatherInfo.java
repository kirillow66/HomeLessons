package ru.sberbank.jd.lesson14;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс содержит в себе информацию о погоде для конкретного города.
 */
public class WeatherInfo {

    private String city;
    public String shortDescription;
    private String description;

    private double temperature;

    private double feelsLikeTemperature;

    private double windSpeed;

    private double pressure;
    private LocalDateTime expiryTime;
    // Private constructor to prevent direct instantiation

    /**
     * Конструктор для создания класса.
     *
     * @param city                 город
     * @param shortDescription     короткое описание погоды
     * @param description          описание погоды
     * @param temperature          температура
     * @param feelsLikeTemperature как ощущается температура
     * @param windSpeed            скорость ветра
     * @param pressure             давление воздуха
     * @param expiryTime           время, до которого актуальна информация.
     */
    public WeatherInfo(String city, String shortDescription, String description, double temperature,
            double feelsLikeTemperature, double windSpeed, double pressure, LocalDateTime expiryTime) {
        this.city = city;
        this.shortDescription = shortDescription;
        this.description = description;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.expiryTime = expiryTime;
    }

    /**
     * Метод для запроса времени акутальности информации.
     *
     * @return время до которого акутальна информация.
     */
    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    /**
     * Класс билдер.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        @JsonProperty("weather")
        private List<Weather> weatherList;
        @JsonProperty("main")
        private Main2 main2;
        private Wind wind;
        private String base;
        private String name;


        private static LocalDateTime expiryTime;

        public Builder expiryTime(LocalDateTime expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }

        /**
         * Метод билдер.
         *
         * @return Объект класса WeatherInfo
         * @throws NullPointerException пареметры не должны быть равны null
         */
        public WeatherInfo build() throws NullPointerException {

            String shDesc = weatherList.get(0).main;
            String desc = weatherList.get(0).description;

            WeatherInfo weatherInfo = new WeatherInfo(this.name, shDesc, desc, main2.temp, main2.feelsLike, wind.speed,
                    main2.pressure, Builder.expiryTime);
            return weatherInfo;

        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Weather {

        @JsonProperty("main")
        private String main;
        private String description;

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Weather{" + "main='" + main + '\'' + ", description='" + description + '\'' + '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Main2 {

        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
        private int pressure;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Wind {

        private double speed;
    }


    @Override
    public String toString() {
        return "WeatherInfo{" + "city='" + city + '\'' + ", shortDescription='" + shortDescription + '\''
                + ", description='" + description + '\'' + ", temperature=" + temperature + ", feelsLikeTemperature="
                + feelsLikeTemperature + ", windSpeed=" + windSpeed + ", pressure=" + pressure + ", expiryTime="
                + expiryTime + '}';
    }
}