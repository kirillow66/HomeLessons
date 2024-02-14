package ru.sberbank.jd.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс для создания url.
 */
@Component
@ConfigurationProperties("myapp")
@Data
public class AppProperties {

    private String serviceUrl;

}
