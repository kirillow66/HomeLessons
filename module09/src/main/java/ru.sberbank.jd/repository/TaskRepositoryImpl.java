package ru.sberbank.jd.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ru.sberbank.jd.controller.input.InputTask;
import ru.sberbank.jd.controller.output.OutputTask;

/**
 * Класс для работы с репозиторием.
 */
public class TaskRepositoryImpl implements TaskRepository {

    private Map<String, OutputTask> tasks = new HashMap<>();

    /**
     * Сохраняет объект в репозиторий.
     *
     * @param inputTask inputTask
     * @return outputTask
     */
    @Override
    public OutputTask save(InputTask inputTask) {
        OutputTask outputTask = OutputTask.builder()
                .id(UUID.randomUUID().toString())
                .owner(inputTask.getOwner())
                .description(inputTask.getDescription())
                .build();
        tasks.put(outputTask.getId(), outputTask);
        return outputTask;
    }

    /**
     * Возвращает объект из репозиторий по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    @Override
    public OutputTask getOutputTaskByIdInRep(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Удаляет обхъект из репозиторияю по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    @Override
    public OutputTask removeTaskByIdInRep(String taskId) {
        return tasks.remove(taskId);
    }
}
