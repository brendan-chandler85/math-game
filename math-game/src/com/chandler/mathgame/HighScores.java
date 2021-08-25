package com.chandler.mathgame;

/**
 * A class made to track the high score of the current session.
 *
 * @author Brendan Chandler
 */
public class HighScores {
    private int highScore;

    public HighScores(){
        highScore = 0;
    }

    //constructor used for testing
    public HighScores(int hs){
        highScore = hs;
    }

    /**
     * A method that displays the current high score.
     */
    public void showHighScore(){
        System.out.printf("The current high score is %d.\n\n", highScore);
    }

    /**
     * A method that checks the current game score against recorded high score.
     *
     * @param score argument submitted to compare current score against high score.
     * @return true if there is a new high score, otherwise return false
     */
    public boolean highScoreCheck(int score){
        if(score > highScore) {
            highScore = score;
            return true;
        }
        return false;
    }
}
