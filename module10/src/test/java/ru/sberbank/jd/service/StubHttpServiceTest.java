package ru.sberbank.jd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StubHttpServiceTest {

    @Autowired
    private StubHttpService stubHttpService;

    @Test
    public void testCallHttpEndpoint() {
        String result = stubHttpService.callHttpEndpoint();
        assertEquals("Stub response", result);
    }
}