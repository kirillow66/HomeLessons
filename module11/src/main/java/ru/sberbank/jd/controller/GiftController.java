package ru.sberbank.jd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.model.GiftOutput;
import ru.sberbank.jd.service.GiftService;


/**
 * Контроллер для запросов.
 */
@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService;

    /**
     * Запрашивает все подарки.
     *
     * @return список подарков
     */
    @GetMapping
    public List<GiftOutput> getAllGifts() {
        return giftService.getAllGifts();
    }

    /**
     * Запрашивает подрок по id.
     *
     * @param id подарка
     * @return подарок
     */
    @GetMapping("/{id}")
    public ResponseEntity<GiftOutput> getGiftById(@PathVariable("id") Long id) {
        GiftOutput giftOutput = giftService.getGiftById(id);
        if (giftOutput != null) {
            return ResponseEntity.ok(giftOutput);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Создаёт новый подарок.
     *
     * @param gift подарок
     * @return созданный подарок
     */
    @PostMapping
    public ResponseEntity<GiftOutput> createGift(@RequestBody Gift gift) {
        GiftOutput createdGift = giftService.createGift(gift);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGift);
    }

    /**
     * Обновляет параметры подарка по его id.
     *
     * @param id   подарка
     * @param gift подарок
     * @return обновлённый подарок.
     */
    @PutMapping("/{id}")
    public ResponseEntity<GiftOutput> updateGift(@PathVariable("id") Long id, @RequestBody Gift gift) {
        GiftOutput updatedGift = giftService.updateGift(id, gift);
        if (updatedGift != null) {
            return ResponseEntity.ok(updatedGift);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Удаляет подарок по id.
     *
     * @param id подарка
     * @return void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGift(@PathVariable("id") Long id) {
        giftService.deleteGift(id);
        return ResponseEntity.noContent().build();
    }
}
