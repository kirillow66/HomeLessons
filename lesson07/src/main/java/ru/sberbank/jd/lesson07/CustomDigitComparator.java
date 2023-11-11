package ru.sberbank.jd.lesson07;

import java.util.Comparator;

/**
 * Класс, определяющий порядок четных и нечетных чисел.
 */
public class CustomDigitComparator implements Comparator<Integer> {

    /**
     * Comparing two numbers.
     *
     * @param lhs the first object to be compared.
     * @param rhs the second object to be compared.
     * @return 0 if equals, 1 if first number is greater, -1 if second number is greater
     */
    @Override
    public int compare(Integer lhs, Integer rhs) {
        if (lhs == null && rhs == null) {
            return 0;
        }
        if (lhs == null) {
            return -1;
        }
        if (rhs == null) {
            return 1;
        }
        if ((lhs % 2 == 0) && (rhs % 2 == 0)) {
            return 0;
        }
        if ((lhs % 2 == 0) && (rhs % 2 != 0)) {
            return -1;
        } else {
            return 1;
        }
    }
}
