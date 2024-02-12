package ru.sberbank.jd.model;

import lombok.Builder;
import lombok.Data;
import ru.sberbank.jd.controller.Gift;

/**
 * Класс лоя создания объекта подарка с присваиванием id.
 */
@Data
@Builder
public class GiftOutput {

    private Long id;
    private String name;
    private String description;
    private double price;

    /**
     * Билдер метод.
     *
     * @param gift подарок
     * @return GiftOutput
     */
    public static GiftOutput giftToGiftOutput(Gift gift) {
        return new GiftOutputBuilder()
                .name(gift.getName())
                .description(gift.getDescription())
                .price(gift.getPrice())
                .build();
    }

}
