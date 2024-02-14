package ru.sberbank.jd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.model.AppProperties;
import ru.sberbank.jd.model.MyRestTemplate;
import ru.sberbank.jd.service.MyHttpService;
import ru.sberbank.jd.service.RealHttpService;
import ru.sberbank.jd.service.StubHttpService;

/**
 * Класс описывает конфигурацию приложения для двух профилей.
 */
@Configuration
public class MyHttpServiceConfig {

    @Bean
    @Profile("prom")
    public MyHttpService realHttpService(AppProperties appProperties, MyRestTemplate myRestTemplate) {
        return new RealHttpService(appProperties, myRestTemplate);
    }

    @Bean
    @Profile("dev")
    public MyHttpService stubHttpService() {
        return new StubHttpService();
    }
}
