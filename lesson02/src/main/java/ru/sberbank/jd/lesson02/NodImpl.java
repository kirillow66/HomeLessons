package ru.sberbank.jd.lesson02;

/**
 * Класс для получения НОД.
 */
public class NodImpl implements Nod {

    /**
     *Метод для получения наибольшего общего делителя.
     *
     * @param first - first digit
     * @param second  - second digit
     * @return наибольший общий делитель
     */
    public int calculate(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Вы ввели отрицательное число");
        }
        if (first == 0 && second == 0) {
            return Integer.MAX_VALUE;
        }
        while (first != 0 && second != 0) {
            if (first > second) {
                first = first % second;
            } else {
                second = second % first;
            }
        }
        return first + second;
    }
}





