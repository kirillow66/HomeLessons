package ru.sberbank.jd.controller;

import lombok.Builder;
import lombok.Data;

/**
 * Создание сущности - подарок.
 */
@Data
public class Gift {

    private String name;
    private String description;
    private double price;


}
