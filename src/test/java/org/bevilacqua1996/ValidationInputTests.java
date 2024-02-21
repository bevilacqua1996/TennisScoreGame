package org.bevilacqua1996;

import org.bevilacqua1996.input.impl.SimpleInputString;
import org.bevilacqua1996.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ValidationInputTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    SimpleInputString simpleInputString = new SimpleInputString();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void notAValidInput() {
        String input = "AABBABC";

        simpleInputString.process(input);

        Assertions.assertEquals(Constants.NOT_A_VALID_INPUT, outContent.toString().trim());
    }

}
