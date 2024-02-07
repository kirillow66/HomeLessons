package ru.sberbank.jd.repository;

import ru.sberbank.jd.controller.input.InputTask;
import ru.sberbank.jd.controller.output.OutputTask;

/**
 * Интерфейс для работы с репозиторием.
 */
public interface TaskRepository {

    /**
     * Сохраняет объект в репозиторий.
     *
     * @param inputTask inputTask
     * @return outputTask
     */
    public OutputTask save(InputTask inputTask);

    /**
     * Возвращает объект из репозиторий по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    OutputTask getOutputTaskByIdInRep(String taskId);

    /**
     * Удаляет обхъект из репозиторияю по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    OutputTask removeTaskByIdInRep(String taskId);
}
