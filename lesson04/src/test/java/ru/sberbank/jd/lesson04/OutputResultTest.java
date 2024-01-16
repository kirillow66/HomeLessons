package ru.sberbank.jd.lesson04;

import static org.junit.Assert.*;

import org.junit.Test;

public class OutputResultTest {

    @Test
    public void getLines() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertEquals(3, result.getLines());
    }

    @Test
    public void getWords() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertEquals(6, result.getWords());
    }

    @Test
    public void isVersion() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertTrue(result.isVersion());
    }

    @Test
    public void isHelp() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertTrue(result.isHelp());
    }

    @Test
    public void isStatusLine() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertTrue(result.isStatusLine());
    }

    @Test
    public void isStatusWords() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertTrue(result.isStatusWords());
    }

    @Test
    public void testToString() {
        OutputResult result = new OutputResult(3, true, 6, true, true, true);
        assertEquals("OutputResult{" +
                "lines=" + 3 +
                ", words=" + 6 +
                ", version=" + true +
                ", help=" + true +
                ", statusLine=" + true +
                ", statusWords=" + true +
                '}', result.toString());
    }
}