package ru.sberbank.jd.controller.input;

import lombok.Data;

/**
 * Класс для входящего объекта.
 */
@Data
public class InputTask {

    private String owner;
    private String description;

}
