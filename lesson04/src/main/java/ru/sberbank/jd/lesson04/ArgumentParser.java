package ru.sberbank.jd.lesson04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, который содержит метод для записи данных из консоли в колекцию.
 */
public class ArgumentParser {

    /**
     * Считывает аргументы и записывает их в коллекцию. Если нет аргуметов запускает команду -lw для стандартного
     * ввода.
     *
     * @param args - arguments
     * @return object of arguments.
     */

    public Arguments parse(String[] args) {
        Map<String, Boolean> flags = new HashMap<>();
        flags.put("-l", false);
        flags.put("-w", false);
        flags.put("--help", false);
        flags.put("--version", false);
        flags.put("-lw", false);
        flags.put("-wl", false);

        List<String> filenames = new ArrayList<>();

        if (args.length < 1) {
            return new Arguments(true, true, false, false, filenames);
        }

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (flags.containsKey(arg)) {
                flags.put(arg, true);
            } else {
                filenames.add(arg);
            }
        }

        if (filenames.size() < 1) {
            throw new RuntimeException("Add filenames in arguments");
        }
        if (filenames.size() > 0 && !flags.containsValue(true)) {
            flags.put("-lw", true);
        }
        return new Arguments(flags.get("-l") || flags.get("-lw") || flags.get("-wl"),
                flags.get("-w") || flags.get("-lw") || flags.get("-wl"), flags.get("--help"), flags.get("--version"),
                filenames);
    }
}
