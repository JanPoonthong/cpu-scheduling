package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testInvalidInputFollowedByValidInput() {
        String simulatedInput = "ab\n2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = Main.readAlgorithmSelection();
        assertEquals(2, result);
    }

    @Test
    void testValidInput() {
        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = Main.readAlgorithmSelection();
        assertEquals(2, result);
    }

    @Test
    void testOutOfRangeInputFollowedByValidInput() {
        String simulatedInput = "5\n1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = Main.readAlgorithmSelection();
        assertEquals(1, result);
    }

    @Test
    void testMultipleInvalidInputsBeforeValidInput() {
        String simulatedInput = "askdj\naskjd\n1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        int result = Main.readAlgorithmSelection();
        assertEquals(1, result);
    }
}