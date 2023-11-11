package ru.sberbank.jd.lesson07;

import org.junit.Assert;
import org.junit.Test;

public class CustomDigitComparatorTest {
    CustomDigitComparator one = new CustomDigitComparator();

    @Test
    public void compare(){
        Assert.assertEquals(1, one.compare(5,2));
    }
    @Test
    public void compare2(){
        Assert.assertEquals(-1, one.compare(6,3));
    }
    @Test
    public void compare3(){
        Assert.assertEquals(0, one.compare(6,2));
    }
    @Test
    public void compare4(){
        Assert.assertEquals(-1, one.compare(null,3));
    }
}