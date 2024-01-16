package ru.sberbank.jd.lesson04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс который содержит метод для подсчета строк и слов.
 */
public class OutputGenerator {

    /**
     * Принимает на вход объект из аргументов. Производит подсчет строк и слов в указаном файле. Создаёт новый объект
     * OutputResult и передаёт ему армуенты и значения количества сток и слов.
     *
     * @param arguments - Object Arguments
     * @return OutputResult - new object OutputResult
     */
    public OutputResult generate(Arguments arguments) {
        StringBuilder content = new StringBuilder();
        List<String> filenames = arguments.getFilenames();
        int totalLines = 0;
        int totalWords = 0;

        if (filenames.size() > 0) {
            for (String filename : filenames) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    int lines = 0;
                    int words = 0;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                        lines++;
                        words += line.split("\\s+").length;
                    }
                    totalLines += lines;
                    totalWords += words;
                    System.out.println("File: " + filename);
                    if (arguments.isLines() && filenames.size() > 1) {
                        System.out.println("Lines: " + lines);
                    }
                    if (arguments.isWords() && filenames.size() > 1) {
                        System.out.println("Words: " + words);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Usage WordCount's arguments:<filename> [-l] [-w] [--help] [--version]");
            System.out.println("Please enter text for counting lines and words. Press Enter twice to finish:");
            Scanner scanner = new Scanner(System.in);
            String line;
            while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
                content.append(line).append("\n");
                totalLines = content.toString().split("\n").length;
                totalWords = content.toString().split("\\s+").length;
            }
        }

        return new OutputResult(totalLines, arguments.isLines(), totalWords, arguments.isWords(),
                arguments.isVersion(), arguments.isHelp());
    }
}
