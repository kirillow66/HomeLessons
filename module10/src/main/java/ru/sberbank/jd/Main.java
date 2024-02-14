package ru.sberbank.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberbank.jd.model.AppProperties;
import ru.sberbank.jd.model.MyRestTemplate;

/**
 * Класс для запуска приложения.
 */
@SpringBootApplication
public class Main {
    private AppProperties appProperties = new AppProperties();
    private MyRestTemplate myRestTemplate = new MyRestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
