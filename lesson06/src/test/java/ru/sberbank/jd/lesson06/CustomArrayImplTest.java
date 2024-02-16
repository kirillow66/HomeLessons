package ru.sberbank.jd.lesson06;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.*;
import org.junit.Test;

public class CustomArrayImplTest {

    CustomArrayImpl<Integer> one = new CustomArrayImpl<>(10);

    @Test
    public void size() {
        one.add(5);
        Assert.assertEquals(1, one.size());
    }

    @Test
    public void isEmpty() {
        one.add(5);
        Assert.assertFalse(one.isEmpty());
    }

    @Test
    public void isEmpty2() {
        Assert.assertTrue(one.isEmpty());
    }

    @Test
    public void add() {
        one.add(5);
        Assert.assertEquals(5, (int) one.get(0));
    }

    @Test
    public void addAll() {
        Integer[] z = new Integer[2];
        for (int i = 0; i < z.length; i++) {
            z[i] = i;
        }
        Assert.assertTrue(one.addAll(z));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAll2() {
        Integer[] z = null;
        Assert.assertFalse(one.addAll(z));
    }

    @Test
    public void testAddAll() {
        Collection<Integer> arrayList = new ArrayList<>(10);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        one.addAll(arrayList);
        Assert.assertTrue(one.addAll(arrayList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAll2() {
        one.addAll((Collection) null);
        Assert.assertFalse(one.addAll((Collection) null));
    }

    @Test
    public void testAddAllIndex() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = 5 + i;
        }
        Assert.assertTrue(one.addAll(0, z));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllIndex2() {
        Integer[] z = null;
        Assert.assertFalse(one.addAll(0, z));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndex3() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = 5 + i;
        }
        Assert.assertFalse(one.addAll(1, z));
    }

    @Test
    public void get() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = 5 + i;
        }
        one.addAll(0, z);
        Assert.assertEquals(7, (int) one.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get2() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = 5 + i;
        }
        one.addAll(0, z);
        Assert.assertEquals(7, (int) one.get(12));
    }

    @Test
    public void set() {
        one.add(1);
        Assert.assertEquals((Integer) 1, one.set(0, 2));
        Assert.assertEquals((Integer) 2, one.set(0, 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set2() {
        Assert.assertEquals((Integer) 2, one.set(12, 5));
    }

    @Test
    public void remove() {
        one.add(5);
        one.remove(0);
        Assert.assertEquals(0, one.size());
    }

    @Test
    public void testRemove() {
        one.add(5);
        Integer z = 5;
        one.remove(z);
        Assert.assertEquals(0, one.size());
    }

    @Test
    public void contains() {
        one.add(5);
        Integer z = 5;
        Assert.assertTrue(one.contains(z));
    }

    @Test
    public void contains2() {
        one.add(5);
        Integer z = 3;
        Assert.assertFalse(one.contains(z));
    }

    @Test
    public void indexOf() {
        one.add(5);
        Integer z = 3;
        Assert.assertEquals(-1, one.indexOf(z));
    }

    @Test
    public void indexOf2() {
        one.add(5);
        Integer z = 5;
        Assert.assertEquals(0, one.indexOf(z));
    }

    @Test
    public void ensureCapacity() {
        one.ensureCapacity(40);
        Assert.assertEquals(40, one.getCapacity());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(10, one.getCapacity());
    }

    @Test
    public void reverse() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = i;
        }
        one.addAll(0, z);
        Integer[] s = new Integer[6];
        for (int i = 0; i < s.length; i++) {
            s[i] = s.length - i - 1;
        }
        CustomArrayImpl<Integer> two = new CustomArrayImpl<>(10);
        two.addAll(s);
        one.reverse();
        String n = one.toString();
        String m = two.toString();
        Assert.assertEquals(n, m);
    }

    @Test
    public void toArray() {
        Integer[] z = new Integer[6];
        for (int i = 0; i < z.length; i++) {
            z[i] = i;
        }
        one.addAll(0, z);
        Assert.assertEquals(z, one.toArray());
    }
}