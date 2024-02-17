package ru.sberbank.jd.lesson04;

import java.util.List;

/**
 * Класс создаёт объект, который содержит заданые аргументы.
 */
public class Arguments {

    private boolean lines;
    private boolean words;
    private boolean help;
    private boolean version;
    private List<String> filenames;

    /**
     * Конструктор с параметрами.
     *
     * @param lines    true если есть запрос на количество строк
     * @param words    true если есть запрос на количество слов
     * @param help     true если есть запрос на вывод строки помощи
     * @param version  true если есть запрос на вывод версии программы
     * @param filenames возвращает имя файла с данными
     */
    public Arguments(boolean lines, boolean words, boolean help, boolean version, List<String> filenames) {
        this.lines = lines;
        this.words = words;
        this.help = help;
        this.version = version;
        this.filenames = filenames;
    }

    /**
     * Сообщает о наличие запроса на количество строк.
     *
     * @return true если есть запрос на вывод количества строк.
     */
    public boolean isLines() {
        return lines;
    }

    /**
     * Сообщает о наличие запроса на количество слов.
     *
     * @return true если есть запрос на вывод количества слов.
     */
    public boolean isWords() {
        return words;
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
     * Сообщает о наличие запроса на вывод версии программы.
     *
     * @return true если есть запрос на вывод кверсии программы.
     */
    public boolean isVersion() {
        return version;
    }

    /**
     * Возвращает имя файла с данными.
     *
     * @return filename
     */
    public List<String> getFilenames() {
        return filenames;
    }

    /**
     * Выводит параметры объекта.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Arguments{"
                + "lines=" + lines
                + ", words=" + words
                + ", help=" + help
                + ", version=" + version
                + ", filename='" + filenames + '\''
                + '}';
    }
}
