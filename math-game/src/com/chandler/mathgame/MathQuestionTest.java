package com.chandler.mathgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCreate() {
        Question q = new MathQuestion(3, 4, "+");
        assertFalse(q.checkAnswer(0));
    }

    @Test
    public void testSubtract() {
        Question q = new MathQuestion(5, 6, "-");
        assertTrue(q.checkAnswer(1));
    }

    @Test
    public void out(){
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void err(){
        System.err.print("hello again");
        assertEquals("hello again", errContent.toString());
    }
}
