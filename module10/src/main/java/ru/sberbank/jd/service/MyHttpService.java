package ru.sberbank.jd.service;

import org.springframework.stereotype.Service;

/**
 * Интерфейс для запроса Endpoint.
 */
public interface MyHttpService {

    /**
     * Метод для запроса Endpoint.
     *
     * @return JSON
     */
    String callHttpEndpoint();
}
