package ru.sberbank.jd.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Класс для создания RestTemplate.
 */
@Data
@Component
public class MyRestTemplate {

    RestTemplate restTemplate = new RestTemplate();

}
