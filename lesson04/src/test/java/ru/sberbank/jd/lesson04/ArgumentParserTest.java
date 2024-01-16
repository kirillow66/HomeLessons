package ru.sberbank.jd.lesson04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArgumentParserTest {

    /**
     * Проверяем класс на прдмет возвращаемых значений, когда аргументы не заданы.
     */
    @Test
    public void testParseArgumentsWithNoArguments() {
        List<String> filenames= new ArrayList<>();
        filenames.add("");
        String[] args = {""};
        ArgumentParser argumentParser = new ArgumentParser();
        Arguments result = argumentParser.parse(args);
        assertEquals(new Arguments(true, true, false, false, filenames).toString(), result.toString());
    }

    /**
     * Проверяем класс на прдмет возвращаемых значений, когда все аргументы заданы.
     */
    @Test
    public void testParseArgumentsWithArguments() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        String[] args = {"Text.txt", "-l", "-w"};
        ArgumentParser argumentParser = new ArgumentParser();
        Arguments result = argumentParser.parse(args);
        assertEquals(new Arguments(true, true, false, false, filenames).toString(), result.toString());
    }
}