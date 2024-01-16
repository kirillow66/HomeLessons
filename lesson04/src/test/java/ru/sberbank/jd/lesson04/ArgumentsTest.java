package ru.sberbank.jd.lesson04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArgumentsTest {

    /**
     * Проверяет коректность возвращаемого значения метода isLines().
     */
    @Test
    public void isLines() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        assertTrue(result.isLines());
    }

    /**
     * Проверяет коректность возвращаемого значения метода isWords().
     */
    @Test
    public void isWords() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        assertTrue(result.isWords());
    }

    /**
     * Проверяет коректность возвращаемого значения метода isHelp().
     */
    @Test
    public void isHelp() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        assertFalse(result.isHelp());
    }

    /**
     * Проверяет коректность возвращаемого значения метода isVersion().
     */
    @Test
    public void isVersion() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        assertFalse(result.isVersion());
    }

    /**
     * Проверяет коректность возвращаемого значения метода getFilename().
     */
    @Test
    public void getFilename() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        assertEquals(filenames, result.getFilenames());
    }

    /**
     * Проверяет коректность возвращаемого значения метода toString().
     */
    @Test
    public void testToString() {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments result = new Arguments(true, true, false, false, filenames);
        String string = "Arguments{" +
                "lines=" + true +
                ", words=" + true +
                ", help=" + false +
                ", version=" + false +
                ", filename='" + filenames + '\'' +
                '}';
        assertEquals(string, result.toString());
    }
}