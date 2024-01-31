package ru.sberbank.jd.lesson14;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.springframework.web.client.RestTemplate;


/**
 * Weather provider.
 */
public class WeatherProvider {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String API_KEY = "0c48922c38f8e6e08091504a58613d63"; // Replace with your actual API key

    /**
     * Download ACTUAL weather info from internet. You should call GET
     * http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key} You should use Spring Rest Template
     * for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                    .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                    .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
            WeatherInfo.Builder builder = objectMapper.readValue(jsonResponse, WeatherInfo.Builder.class);
            WeatherInfo info = builder
                    .expiryTime(LocalDateTime.now().plusMinutes(5))
                    .build();
            return info;
        } catch (Exception e) {
            System.out.println("Error fetching weather info: " + e.getMessage());
            return null;
        }
    }
}
