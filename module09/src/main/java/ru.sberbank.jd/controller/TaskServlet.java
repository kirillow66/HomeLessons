package ru.sberbank.jd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.sberbank.jd.controller.input.InputTask;
import ru.sberbank.jd.controller.output.OutputTask;
import ru.sberbank.jd.service.TaskService;

/**
 * Сервлет для работы с задачами приходящими на /task.
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    private ObjectMapper mapper;
    private TaskService taskService;

    /**
     * Инит метод. Создаёт объекты необходимые для работы с задачами.
     *
     * @param config config
     * @throws ServletException ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.mapper = new ObjectMapper();
        this.taskService = new TaskService();
    }

    /**
     * Пост метод. добавляет объект в репозиторий.
     *
     * @param request  request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InputTask inputTask = getInputTask(request);
        OutputTask outputTask = taskService.tasking(inputTask);
        setResponse(response, outputTask);
    }

    /**
     * Гет метод. Возвращает объект из репозитория по id.
     *
     * @param request  request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskId = request.getParameter("id");
        OutputTask outputTask = taskService.getOutputTaskById(taskId);
        setResponse(response, outputTask);
    }

    /**
     * Дэлит метод. Удаляет объект из репозитория по id.
     *
     * @param request  request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskId = request.getParameter("id");
        OutputTask outputTask = taskService.removeTaskById(taskId);
        setResponse(response, outputTask);
    }

    /**
     * Отправляет JSON.
     *
     * @param response   response
     * @param outputTask outputTask
     * @throws IOException IOException
     */
    private void setResponse(HttpServletResponse response, OutputTask outputTask) throws IOException {
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), outputTask);
    }

    /**
     * Принимает JSON. Записывает в объект.
     *
     * @param request request
     * @return inputTask
     * @throws IOException IOException
     */
    private InputTask getInputTask(HttpServletRequest request) throws IOException {
        InputTask inputTask = mapper.readValue(request.getReader(), InputTask.class);
        return inputTask;
    }
}

