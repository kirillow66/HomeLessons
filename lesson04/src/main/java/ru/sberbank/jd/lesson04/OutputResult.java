package ru.sberbank.jd.lesson04;

/**
 * Класс который созаёт объект с данными о количестве стро и слов и необходимости вывода парматров на экран.
 */
public class OutputResult {

    private int lines;
    private int words;
    private boolean version;
    private boolean help;
    private boolean statusLine;
    private boolean statusWords;

    /**
     * Коструктор с параметрами.
     *
     * @param lines       количество строк
     * @param statusLine  true если нужно вывести количество строк
     * @param words       количество слов
     * @param statusWords true если нужно вывести количество слов
     * @param version     true если нужно вывести версию программы
     * @param help        true если нужно вывести строку помощи
     */
    public OutputResult(int lines, boolean statusLine, int words, boolean statusWords, boolean version, boolean help) {
        this.lines = lines;
        this.words = words;
        this.version = version;
        this.help = help;
        this.statusLine = statusLine;
        this.statusWords = statusWords;
    }

    /**
     * Возвращает количество строк.
     *
     * @return lines количество строк
     */
    public int getLines() {
        return lines;
    }

    /**
     * Возвращает количество слов.
     *
     * @return words количество слов
     */
    public int getWords() {
        return words;
    }

    /**
     * Сообщает о наличие запроса на вывод версии программы.
     *
     * @return true если есть запрос на вывод кверсии программы.
     */
    public boolean isVersion() {
        return version;
    }

    /**
     * Сообщает о наличие запроса на вывод строки помощи.
     *
     * @return true если есть запрос на вывод строки помощи.
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * Сообщает о наличие запроса на количество строк.
     *
     * @return true если есть запрос на вывод количества строк.
     */
    public boolean isStatusLine() {
        return statusLine;
    }

    /**
     * Сообщает о наличие запроса на количество слов.
     *
     * @return true если есть запрос на вывод количества слов.
     */
    public boolean isStatusWords() {
        return statusWords;
    }

    /**
     * Выводит параметры объекта.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "OutputResult{"
                + "lines=" + lines
                + ", words=" + words
                + ", version=" + version
                + ", help=" + help
                + ", statusLine=" + statusLine
                + ", statusWords=" + statusWords
                + '}';
    }
}
