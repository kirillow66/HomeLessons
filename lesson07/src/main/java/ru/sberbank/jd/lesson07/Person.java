package ru.sberbank.jd.lesson07;

import java.util.Objects;

/**
 * Класс для хранения данных о человеке.
 */
public class Person implements Comparable<Person> {

    private String name;
    private String city;
    private int age;

    /**
     * Create new object Person.
     *
     * @param name - person's name
     * @param city - person's city
     * @param age  -  person's age
     */
    public Person(String name, String city, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Print class Person.
     *
     * @return Person to string
     */
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", city='" + city + '\'' + ", age=" + age + '}';
    }

    /**
     * Return name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Return city.
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Return age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Equals two objects.
     *
     * @return true if equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name.equalsIgnoreCase(person.name) && city.equalsIgnoreCase(person.city);
    }

    /**
     * Return hash code.
     *
     * @return objects's hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), city.toLowerCase(), age);
    }

    /**
     * Comparing two numbers.
     *
     * @return 0 if equals, 1 if first number is greater, -1 if second number is greater
     */
    @Override
    public int compareTo(Person obj) {
        int result = this.city.compareToIgnoreCase(obj.city);
        if (result == 0) {
            return this.name.compareToIgnoreCase(obj.name);
        }
        return result;
    }
}
