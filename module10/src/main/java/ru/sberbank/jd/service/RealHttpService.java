package ru.sberbank.jd.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.model.AppProperties;
import ru.sberbank.jd.model.MyRestTemplate;

/**
 * Класс для реальных запросов.
 */
@Slf4j
public class RealHttpService implements MyHttpService {

    private final AppProperties appProperties;
    private final RestTemplate restTemplate;

    public RealHttpService(AppProperties appProperties, MyRestTemplate myRestTemplate) {
        this.appProperties = appProperties;
        this.restTemplate = myRestTemplate.getRestTemplate();
    }

    /**
     * Метод для реальных запросов.
     *
     * @return JSON
     */
    @Override
    @PostConstruct
    public String callHttpEndpoint() {
        log.info("My Real invoked!!!!!");
        return restTemplate.getForObject(appProperties.getServiceUrl(), String.class);
    }
}
