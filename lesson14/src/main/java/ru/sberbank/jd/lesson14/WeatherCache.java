package ru.sberbank.jd.lesson14;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import ru.sberbank.jd.lesson14.WeatherInfo.Builder;

/**
 * Потокобезопасный кеш, который позволяет получить актуальную информацио о погоде. Информация считается актуальной в
 * течение 5 минут после загрузки из интернета.
 */
public class WeatherCache {

    private Map<String, WeatherInfo> cache = new HashMap<>();
    private WeatherProvider weatherProvider;

    public WeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Позволяет добавить в кэш загруженную информацию и считать из кэша если информация уже есть.
     *
     * @param city город, по которому запрашивается информация.
     * @return Информация о запрашиваемом городе.
     */
    public WeatherInfo getWeatherInfo(String city) {
        synchronized (cache) {
            WeatherInfo info = cache.get(city);
            if (info == null || info.getExpiryTime().isBefore(LocalDateTime.now())) {
                info = weatherProvider.get(city);
                cache.remove(city);
                cache.put(city, info);
            }
            return info;
        }
    }

    /**
     * Метод для удаления информации о городе из кэша.
     *
     * @param city название удалённого города
     */
    public void removeWeatherInfo(String city) {
        synchronized (cache) {
            cache.remove(city);
        }
    }
}

