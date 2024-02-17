package ru.sberbank.jd.lesson04;

/**
 * Класс, который содержит метод для вывода на экран информации по запросу.
 */
public class ResultPrinter {

    /**
     * Выводит на экран информацию по запросу.
     *
     * @param result объекст содержащий информацию из запроса и данные из файла
     */
    public void output(OutputResult result) {
        if (result.isStatusLine()) {
            System.out.println("Totallines = " + result.getLines());
        }
        if (result.isStatusWords()) {
            System.out.println("TotalWords = " + result.getWords());
        }
        if (result.isVersion()) {
            System.out.println("Version: version01, Kirillov");
        }
        if (result.isHelp()) {
            System.out.println("Usage: java WordCounter <filename> [-l] [-w] [--help] [--version]");
        }
    }
}
