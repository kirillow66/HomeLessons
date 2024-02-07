package ru.sberbank.jd.controller.output;

import lombok.Builder;
import lombok.Data;

/**
 * Класс объекта для отправки.
 */
@Data
@Builder
public class OutputTask {

    private String id;
    private String owner;
    private String description;

}
