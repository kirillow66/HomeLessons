package ru.sberbank.jd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.controller.Gift;
import ru.sberbank.jd.model.GiftOutput;
import ru.sberbank.jd.repository.GiftRepository;

/**
 * Сервисный класс для выполнения запросов.
 */
@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    /**
     * Запрашивает все подарки.
     *
     * @return список подарков
     */
    public List<GiftOutput> getAllGifts() {
        return giftRepository.findAll();
    }

    /**
     * Запрашивает подарок по id.
     *
     * @param id подарка.
     * @return подарок
     */
    public GiftOutput getGiftById(Long id) {
        return giftRepository.findById(id).orElse(null);
    }

    /**
     * Создаёт новый подарок.
     *
     * @param gift подарок
     * @return созданный подарок
     */
    public GiftOutput createGift(Gift gift) {

        return giftRepository.save(gift);
    }

    /**
     * Обновляет параметры подарка по id.
     *
     * @param id   подарка
     * @param gift подарок
     * @return обновлённый подарок
     */
    public GiftOutput updateGift(Long id, Gift gift) {
        if (giftRepository.findById(id).isPresent()) {
            GiftOutput giftOutput = GiftOutput.giftToGiftOutput(gift);
            giftOutput.setId(id);
            return giftRepository.update(giftOutput);
        }
        return null;
    }

    public void deleteGift(Long id) {
        giftRepository.deleteById(id);
    }
}
