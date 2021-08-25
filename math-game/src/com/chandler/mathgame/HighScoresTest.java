package com.chandler.mathgame;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HighScoresTest {

    @Test
    public void testNewHighScore() {
        HighScores hs = new HighScores();
        assertTrue(hs.highScoreCheck(6));
    }

    @Test
    public void testNotHighScore() {
        HighScores hs = new HighScores(9);
        assertFalse(hs.highScoreCheck(5));
    }
}
