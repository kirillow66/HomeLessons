package ru.sberbank.jd.lesson04;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class OutputGeneratorTest {

    /**
     * Проверяем класс на прдмет возвращаемых значений.
     */
    @Test
    public void outputGeneratorTest() throws IOException {
        List<String> filenames= new ArrayList<>();
        filenames.add("Text.txt");
        Arguments arguments = new Arguments(true, true, false, false, filenames);
        OutputGenerator outputGenerator = new OutputGenerator();
        String string = "Раз Два" + "\n" + "Три четыре Пять" +
                "\n" + "Шесть";
        FileOutputStream fileOutputStream = new FileOutputStream("Text.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(string);
        objectOutputStream.close();
        assertEquals(new OutputResult(3, true, 6, true, false, false).toString(),
                outputGenerator.generate(arguments).toString());
    }
}