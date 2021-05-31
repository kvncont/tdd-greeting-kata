package com.github.kvncont.tddgreetingkata.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setup(){
        greetingService = new GreetingService();
    }

    @Test
    void checkOneName() {
        List<String> name = new ArrayList<>(Collections.singletonList("Bob"));
        String expected = "Hello, Bob.";
        assertEquals(expected, greetingService.greeting(name));
    }

    @Test
    void checkNullName() {
        String expected = "Hello, my friend.";
        assertEquals(expected, greetingService.greeting(null));
    }

    @Test
    void checkIfNameIsInUppercase() {
        List<String> name = new ArrayList<>(Collections.singletonList("JERRY"));
        String expected = "HELLO JERRY!";
        assertEquals(expected, greetingService.greeting(name));
    }

    @Test
    void checkTwoNames() {
        List<String> name = new ArrayList<>(Arrays.asList("Jill", "Jane"));
        String expected = "Hello, Jill and Jane.";
        assertEquals(expected, greetingService.greeting(name));
    }

    @Test
    void checkMoreThanTwoNames() {
        List<String> name = new ArrayList<>(Arrays.asList("Amy", "Brian", "Charlotte"));
        String expected = "Hello, Amy, Brian, and Charlotte.";
        GreetingService greetingService = new GreetingService();
        assertEquals(expected, greetingService.greeting(name));
    }

    @Test
    void allowMixingNames() {
        List<String> name = new ArrayList<>(Arrays.asList("Amy", "BRIAN", "Charlotte"));
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
        assertEquals(expected, greetingService.greeting(name));
    }

    @Test
    void allowSplitNamesWithCommas(){
        List<String> name = new ArrayList<>(Arrays.asList("Bob", "Charlie, Dianne"));
        String expected = "Hello, Bob, Charlie, and Dianne.";
        assertEquals(expected, greetingService.greeting(name));
    }
}
