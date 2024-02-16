package ru.sberbank.jd.lesson12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import ru.sberbank.jd.lesson12.model.Student;


public class StudentsRepositoryCrudImplTest {

    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13.8-alpine");

    @BeforeClass
    public static void startContainer() {
        postgres.start();
        System.setProperty("DB_URL", postgres.getJdbcUrl());
        System.setProperty("DB_USERNAME", postgres.getUsername());
        System.setProperty("DB_PASSWORD", postgres.getPassword());

        try (Connection connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(),
                postgres.getPassword())) {
            String createTableSql = "CREATE TABLE students (id UUID, first_name VARCHAR(255), last_name VARCHAR(255), birth_date DATE, is_graduated BOOLEAN)";
            try (java.sql.Statement statement = connection.createStatement()) {
                statement.execute(createTableSql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void stopContainer() {
        postgres.stop();
    }

    @Test
    public void createAndSelectByIdTest() {
        Date date = new Date(1980, 12, 5);
        Student student = new Student("Ivan", "Ivanov", date, false);
        StudentsRepositoryCrudImpl repository = new StudentsRepositoryCrudImpl(System.getProperty("DB_URL"),
                System.getProperty("DB_USERNAME"), System.getProperty("DB_PASSWORD"));
        UUID id = repository.create(student);
        assertNotNull(id);
        Student selectedStudent = repository.selectById(id);
        assertNotNull(selectedStudent);
        assertEquals("Ivan", selectedStudent.getFirstName());
        assertEquals("Ivanov", selectedStudent.getLastName());
        assertEquals(date, selectedStudent.getBirthDate());
        assertEquals(false, selectedStudent.isGraduated());
    }

    @Test
    public void testSelectAll() {
        Date date = new Date(1981, 11, 6);
        StudentsRepositoryCrudImpl repository = new StudentsRepositoryCrudImpl(System.getProperty("DB_URL"),
                System.getProperty("DB_USERNAME"), System.getProperty("DB_PASSWORD"));
        List<Student> students = repository.selectAll();
        assertNotNull(students);
        assertEquals(0, students.size());
        Student student = new Student("Oleg", "Olegov", date, false);
        repository.create(student);
        students = repository.selectAll();
        assertNotNull(students);
        assertEquals(1, students.size());
    }

    @Test
    public void testUpdate() {
        Date date = new Date(1982, 10, 7);
        Date date2 = new Date(1983, 9, 8);
        StudentsRepositoryCrudImpl repository = new StudentsRepositoryCrudImpl(System.getProperty("DB_URL"),
                System.getProperty("DB_USERNAME"), System.getProperty("DB_PASSWORD"));
        Student student = new Student("Alex", "Aleksndrov", date, false);
        UUID id = repository.create(student);
        student.setFirstName("Miha");
        student.setLastName("Mihailov");
        student.setDate(date2);
        student.setIsGraduated(true);
        student.addId(id);
        int rowsUpdated = repository.update(student);
        assertEquals(1, rowsUpdated);
        Student updatedStudent = repository.selectById(id);
        assertNotNull(updatedStudent);
        assertEquals("Miha", updatedStudent.getFirstName());
        assertEquals("Mihailov", updatedStudent.getLastName());
        assertEquals(date2, updatedStudent.getBirthDate());
        assertEquals(true, updatedStudent.isGraduated());
    }

    @Test
    public void testRemove() {
        Date date = new Date(1980, 12, 5);
        Date date2 = new Date(1983, 9, 8);
        Student student1 = new Student("Ivan", "Ivanov", date, false);
        Student student2 = new Student("Alex", "Aleksndrov", date, false);
        StudentsRepositoryCrudImpl repository = new StudentsRepositoryCrudImpl(System.getProperty("DB_URL"),
                System.getProperty("DB_USERNAME"), System.getProperty("DB_PASSWORD"));
        List<UUID> idList = new ArrayList<>();
        UUID id1 = repository.create(student1);
        UUID id2 = repository.create(student2);
        idList.add(id1);
        idList.add(id2);
        int rowsDeleted = repository.remove(idList);
        assertEquals(2, rowsDeleted);
        assertNull(repository.selectById(id1));
        assertNull(repository.selectById(id2));
    }
}