package ru.sberbank.jd.lesson07;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    Person one = new Person("Masha", "SPb", 25);
    Person two = new Person("masha", "spb", 25);
    Person three = new Person("Kirill", "SPb", 30);

    @Test
    public void testToString() {
        Assert.assertEquals("Person{name='Masha', city='SPb', age=25}", one.toString());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Masha", one.getName());
    }

    @Test
    public void getCity() {
        Assert.assertEquals("SPb", one.getCity());
    }

    @Test
    public void getAge() {
        Assert.assertEquals(25, one.getAge());
    }

    @Test
    public void testEqualsAndHashCode() {
        Assert.assertEquals(two, one);
        Assert.assertEquals(one.hashCode(), two.hashCode());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(0, one.compareTo(two));
    }

    @Test
    public void compareTo2() {
        Assert.assertEquals(2, one.compareTo(three));
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareTo3() {
        Person four = new Person(null, "SPb", 30);
        Assert.assertEquals(0, four.compareTo(one));
    }
}