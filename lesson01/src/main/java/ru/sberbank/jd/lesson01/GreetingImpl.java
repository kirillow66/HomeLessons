package ru.sberbank.jd.lesson01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс для получения персональной информации.
 */
public class GreetingImpl implements Greeting {

    private String firstName;
    private String lastName;
    private int birthYear;
    private String gitHubUrl;
    private String phone;
    private Collection<String> courseExpectations;
    private Collection<String> hobbie;

    /**
     * Безымянный конструктор.
     */
    public GreetingImpl() {
        firstName = "Kirill";
        lastName = "Kirillov";
        birthYear = 1993;
        gitHubUrl = "https://github.com/kirillow66/HomeLessons.git";
        phone = "+79119729712";

        hobbie = new ArrayList<>();
        hobbie.add("Тяжелая атлетика");
        hobbie.add("Йога");
        hobbie.add("Психология");

        courseExpectations = new ArrayList<>();
        courseExpectations.add("Выучить язык Java");
        courseExpectations.add("Понимать принципы(логику) использования языка и инструментов для его использования");
        courseExpectations.add("Уметь быстро находить пути решения задачи");
    }

    /**
     * Возвращает имя.
     *
     * @return firstName имя
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Возвращает фамилию.
     *
     * @return lastName фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Возвращает дату рождения.
     *
     * @return birthYear дата рождения
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Возвращает хобби.
     *
     * @return hobbie хобби
     */
    public Collection<String> getHobbies() {
        return hobbie;
    }

    /**
     * Возвращает ссылку на гит хаб.
     *
     * @return gitHubUrl ссылка
     */
    public String getGitHubUrl() {
        return gitHubUrl;
    }

    /**
     * Возвращает номер телефона.
     *
     * @return phone номер телефона
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Возвращает цели курса.
     *
     * @return courseExpectations цели курса
     */
    public Collection<String> getCourseExpectations() {
        return courseExpectations;
    }

}


