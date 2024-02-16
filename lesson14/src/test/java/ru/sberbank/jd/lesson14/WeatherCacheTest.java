package ru.sberbank.jd.lesson14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import org.junit.*;
import org.junit.Test;

public class WeatherCacheTest {
    private WeatherProvider weatherProvider;
    private WeatherCache weatherCache;


    @Test
    public void testEmptyCachePositiveScenario() {
        weatherProvider = mock(WeatherProvider.class);
        weatherCache = new WeatherCache(weatherProvider);
        String city = "Moscow";
        WeatherInfo weatherInfo = new WeatherInfo(city, "Clouds",
                "overcast clouds", 272.07, 269.4,
                1.96, 1027.0, LocalDateTime.now().plusMinutes(5));
        when(weatherProvider.get(city)).thenReturn(weatherInfo);
        WeatherInfo result = weatherCache.getWeatherInfo(city);
        assertEquals(weatherInfo, result);
        verify(weatherProvider, times(1)).get(city);
    }

    @Test
    public void testGetActualWeatherInfoFromCache() {
        weatherProvider = mock(WeatherProvider.class);
        weatherCache = new WeatherCache(weatherProvider);
        String city = "Moscow";
        WeatherInfo weatherInfo = new WeatherInfo(city, "Clouds",
                "overcast clouds", 272.07, 269.4,
                1.96, 1027.0, LocalDateTime.now().plusMinutes(5));
        when(weatherProvider.get(city)).thenReturn(weatherInfo);
        weatherCache.getWeatherInfo(city);
        WeatherInfo result = weatherCache.getWeatherInfo(city);
        assertEquals(weatherInfo, result);
        WeatherInfo result2 = weatherCache.getWeatherInfo(city);
        assertEquals(weatherInfo, result2);
        verify(weatherProvider, times(1)).get(city);
    }

    @Test
    public void testCacheContainsOutdatedInfo() {
        weatherProvider = mock(WeatherProvider.class);
        weatherCache = new WeatherCache(weatherProvider);
        String city = "Moscow";
        WeatherInfo weatherInfo = new WeatherInfo(city, "Clouds",
                "overcast clouds", 272.07, 269.4,
                1.96, 1027.0, LocalDateTime.now().minusMinutes(5));
        when(weatherProvider.get(city)).thenReturn(weatherInfo);
        weatherCache.getWeatherInfo(city);
        WeatherInfo result = weatherCache.getWeatherInfo(city);
        assertEquals(weatherInfo, result);
        WeatherInfo result2 = weatherCache.getWeatherInfo(city);
        assertEquals(weatherInfo, result2);
        verify(weatherProvider, times(3)).get(city);
    }

    @Test
    public void testNonExistingCity() {
        weatherProvider = mock(WeatherProvider.class);
        weatherCache = new WeatherCache(weatherProvider);
        String city = "qwerty";
        when(weatherProvider.get(city)).thenReturn(null);
        WeatherInfo result = weatherCache.getWeatherInfo(city);
        assertNull(result);
        verify(weatherProvider, times(1)).get(city);
    }

}