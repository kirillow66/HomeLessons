package ru.sberbank.jd.lesson01;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;

public class GreetingImplTest {

    GreetingImpl greetingImpl = new GreetingImpl();

    @Test
    public void getFirstName() {
        Assert.assertEquals("Kirill", greetingImpl.getFirstName());
    }

    @Test
    public void getLastName() {
        Assert.assertEquals("Kirillov", greetingImpl.getLastName());
    }

    @Test
    public void getBirthYear() {
        Assert.assertEquals(1993, greetingImpl.getBirthYear());
    }

    @Test
    public void getHobbies() {
        Collection<String> hobbie = new ArrayList<>();
        hobbie.add("Тяжелая атлетика");
        hobbie.add("Йога");
        hobbie.add("Психология");
        Assert.assertEquals(hobbie, greetingImpl.getHobbies());
    }

    @Test
    public void getCourseExpectations() {
        Collection<String> courseExpectations = new ArrayList<>();
        courseExpectations.add("Выучить язык Java");
        courseExpectations.add("Понимать принципы(логику) использования языка и инструментов для его использования");
        courseExpectations.add("Уметь быстро находить пути решения задачи");
        Assert.assertEquals(courseExpectations, greetingImpl.getCourseExpectations());
    }

    @Test
    public void getGitHubUrl() {
        Assert.assertEquals("https://github.com/kirillow66/HomeLessons.git", greetingImpl.getGitHubUrl());
    }

    @Test
    public void getPhone() {
        Assert.assertEquals("+79119729712", greetingImpl.getPhone());
    }

}



