package ru.sberbank.jd.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.controller.Gift;
import ru.sberbank.jd.model.GiftOutput;

/**
 * Интерфей репозитория.
 */
@Repository
public interface GiftRepository {

    List<GiftOutput> findAll();

    Optional<GiftOutput> findById(Long id);

    GiftOutput save(Gift gift);

    GiftOutput update(GiftOutput giftOutput);

    void deleteById(Long id);
}
