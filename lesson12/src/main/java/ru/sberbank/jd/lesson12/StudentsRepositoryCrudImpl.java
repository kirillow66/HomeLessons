package ru.sberbank.jd.lesson12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.model.Student;

/**
 * Класс для взаимодействий с таблицей students.
 */
public class StudentsRepositoryCrudImpl {

    private String url;
    private String user;
    private String password;

    /**
     * Конструктор для создания класса.
     *
     * @param url      - url подключения
     * @param user     - логин
     * @param password - пароль
     */
    public StudentsRepositoryCrudImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Метод для внесения данных в таблицу students из экзэмпляра student.
     *
     * @param student - экзэмпляр класса student
     * @return id
     */
    public UUID create(Student student) {
        UUID id = UUID.randomUUID();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO students (id, first_name, last_name, birth_date, "
                    + "is_graduated) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setObject(1, id);
                statement.setString(2, student.getFirstName());
                statement.setString(3, student.getLastName());
                statement.setDate(4, new java.sql.Date(student.getBirthDate().getTime()));
                statement.setBoolean(5, student.isGraduated());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Возвращает данные из таблицы по id.
     *
     * @param id - id студента
     * @return - возвращает экземпляр класса student
     */
    public Student selectById(UUID id) {
        Student student = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM students WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setObject(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        student = new Student(resultSet.getString("first_name"), resultSet.getString("last_name"),
                                resultSet.getDate("birth_date"), resultSet.getBoolean("is_graduated"));
                        student.setId((UUID) resultSet.getObject("id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Получение всех записей из БД.
     *
     * @return записи
     */
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM students";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Student student = new Student(resultSet.getString("first_name"),
                                resultSet.getString("last_name"), resultSet.getDate("birth_date"),
                                resultSet.getBoolean("is_graduated"));
                        student.setId((UUID) resultSet.getObject("id"));
                        students.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * Обновление записи в БД.
     *
     * @param student измененная запись
     * @return количество обновленных записей
     */
    public int update(Student student) {
        int rowsUpdated = 0;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE students SET first_name = ?, last_name = ?, birth_date = ?, "
                    + "is_graduated = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setDate(3, new java.sql.Date(student.getBirthDate().getTime()));
                statement.setBoolean(4, student.isGraduated());
                statement.setObject(5, student.getId());
                rowsUpdated = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    /**
     * Удаление указанных записей по id.
     *
     * @param idList список идентификаторов записей
     * @return количество удаленных записей
     */
    public int remove(List<UUID> idList) {
        int rowsDeleted = 0;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (UUID id : idList) {
                    statement.setObject(1, id);
                    rowsDeleted += statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsDeleted;
    }
}


