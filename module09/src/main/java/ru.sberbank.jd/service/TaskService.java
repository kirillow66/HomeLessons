package ru.sberbank.jd.service;

import ru.sberbank.jd.controller.input.InputTask;
import ru.sberbank.jd.controller.output.OutputTask;
import ru.sberbank.jd.repository.TaskRepository;
import ru.sberbank.jd.repository.TaskRepositoryImpl;

/**
 * Класс для работы с задачами.
 */
public class TaskService {

    TaskRepository taskRepository = new TaskRepositoryImpl();

    /**
     * Вызывает метод для записи объекта в репозиторий.
     *
     * @param inputTask inputTask
     * @return outputTask
     */
    public OutputTask tasking(InputTask inputTask) {
        OutputTask outputTask = taskRepository.save(inputTask);
        return outputTask;
    }

    /**
     * Вызывает метод, чтобы вернуть обхект из репозиторий по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    public OutputTask getOutputTaskById(String taskId) {
        return taskRepository.getOutputTaskByIdInRep(taskId);
    }

    /**
     * Вызывает метод, чтобы удалить объект из репозитория по id.
     *
     * @param taskId taskId
     * @return outputTask
     */
    public OutputTask removeTaskById(String taskId) {
        return taskRepository.removeTaskByIdInRep(taskId);
    }
}
