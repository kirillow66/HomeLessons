package ru.sberbank.jd.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс заглушка для запросов.
 */
@Slf4j
public class StubHttpService implements MyHttpService {

    /**
     * Метод заглушка для запросов.
     *
     * @return сообщение Stub response.
     */
    @Override
    @PostConstruct
    public String callHttpEndpoint() {
        return "Stub response";
    }
}
