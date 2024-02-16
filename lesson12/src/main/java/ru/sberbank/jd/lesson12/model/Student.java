package ru.sberbank.jd.lesson12.model;


import java.util.Date;
import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.StudentsRepositoryCrud;

/**
 * Класс, отражающий структуру хранимых в таблице полей.
 */
public class Student {

    private UUID id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private boolean isGraduated;

    /**
     * Конструктор класса Student.
     *
     * @param firstName   - имя студента
     * @param lastName    - фамилия студента
     * @param birthDate   - дата рождения студента
     * @param isGraduated статус окончания обучения.
     */
    public Student(String firstName, String lastName, Date birthDate, boolean isGraduated) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isGraduated = isGraduated;
    }

    /**
     * Возвращает id.
     *
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Возвращае имя студента.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Возвращает фамилию студента.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Возвращает дату рожденияю.
     *
     * @return birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает статус окончания вуза.
     *
     * @return isGraduated
     */
    public boolean isGraduated() {
        return isGraduated;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate + ", isGraduated=" + isGraduated + '}';
    }

    public void addId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIsGraduated(Boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    public void setDate(Date date) {
        this.birthDate = date;
    }
}
