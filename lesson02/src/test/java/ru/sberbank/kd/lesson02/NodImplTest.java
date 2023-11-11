package ru.sberbank.kd.lesson02;

import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.jd.lesson02.NodImpl;

public class NodImplTest {

    NodImpl nod = new NodImpl();

    @Test
    public void calculate1() {
        Assert.assertEquals(5, nod.calculate(0, 5));
    }

    @Test
    public void calculate2() {
        Assert.assertEquals(1, nod.calculate(1, 1));
    }

    @Test
    public void calculate3() {
        Assert.assertEquals(6, nod.calculate(12, 18));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate4() {
        Assert.assertEquals(5, nod.calculate(-1, 12));
    }

    @Test
    public void calculate5() {
        Assert.assertEquals(Integer.MAX_VALUE, nod.calculate(0, 0));
    }
}
