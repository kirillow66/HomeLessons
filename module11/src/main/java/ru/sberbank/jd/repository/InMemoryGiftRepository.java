package ru.sberbank.jd.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.controller.Gift;
import ru.sberbank.jd.model.GiftOutput;

/**
 * Класс создаёт репозиторий и выполняет операции с ним.
 */
@Repository
public class InMemoryGiftRepository implements GiftRepository {

    private Map<Long, GiftOutput> giftMap = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    @Override
    public List<GiftOutput> findAll() {
        return new ArrayList<>(giftMap.values());
    }

    @Override
    public Optional<GiftOutput> findById(Long id) {
        return Optional.ofNullable(giftMap.get(id));
    }

    @Override
    public GiftOutput save(Gift gift) {
        GiftOutput giftOutput = GiftOutput.giftToGiftOutput(gift);
        giftOutput.setId(nextId.getAndIncrement());
        giftMap.put(giftOutput.getId(), giftOutput);
        return giftOutput;
    }

    @Override
    public GiftOutput update(GiftOutput giftOutput) {
        giftMap.put(giftOutput.getId(), giftOutput);
        return giftOutput;
    }

    @Override
    public void deleteById(Long id) {
        giftMap.remove(id);
    }

}
