package com.chandler.mathgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple console-based maths quiz for primary school children.
 *
 * @author Brendan Chandler
 */
public class Main {

    private int score = 0;
    private HighScores highScore = new HighScores();
    private Scanner input = new Scanner(System.in);
    private ArrayList<Question> questions = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.playMultipleGames();
    }

    /**
     * A method that sets up the questions array list and generates questions.
     * @param rand random object passed as an argument to question objects.
     */
    public void runQuestions(Random rand){
        for(int i = 0; i < 9; i++){
            Question q = new MathQuestion(rand);
            questions.add(q);
        }

        for(int i = 0; i < questions.size(); i++){
            Question q = questions.get(i);
            System.out.printf("%d) ", i + 1);
            q.showQuestion();
            int response = input.nextInt();

            if(q.checkAnswer(response) && i < 9){
                score++;
            } else if(q.checkAnswer(response) && i >= 10) {
                System.out.println("Good job!");
            } else if(i == questions.size() - 1){
                Question jq = new JokeQuestion();
                jq.showQuestion();
                response = input.nextInt();
                if (jq.checkAnswer(response)){
                    System.out.printf("One to screw in the lightbulb and %d to code the ladder.\n", response - 1);
                    score++;
                }
            } else {
                questions.add(q);
            }
        }
    }

    /**
     * A method that runs the maths game.
     */
    public void playMultipleGames(){
        boolean runGame = true;

        while(runGame) {
            Random rand = new Random(System.currentTimeMillis());
            highScore.showHighScore();
            long startTime = System.currentTimeMillis();

            runQuestions(rand);
            System.out.printf("Your final score: %d\n", score);

            postGame(score);

            long finishTime = System.currentTimeMillis();
            double elapsed = (finishTime - startTime) / 1000.0;

            System.out.printf("Game completed after %5.2f seconds.\n", elapsed);


            boolean playAgainCheck = endOfGame();

            if(playAgainCheck){
                score = 0;
                System.out.println("Starting new game.");
            } else {
                System.out.println("Thank you for playing.");
                runGame = false;
            }
        }
        input.close();
    }

    /**
     * A method that displays the results of the game and runs a high score check
     *
     * @param score Used to print a statement
     */
    public void postGame(int score){
        boolean highScoreCheck = highScore.highScoreCheck(score);

        if(score < 5){
            System.out.println("Good start. Can you practice to improve your score?");
        } else if (score < 8){
            System.out.println("Excellent work, keep at it and you'll keep improving.");
        } else {
            System.out.println("Fantastic work.");
        }

        if (highScoreCheck){
            System.out.printf("Congratulations, your new high score is %d.\n", score);
        }
    }

    /**
     * A method that runs an infinite loop that breaks only on valid input.
     *
     * @return gameOver is set to true when user enters 'y', false for 'n'.
     */
    public boolean endOfGame(){
        String answer;
        boolean gameOver;
        while(true){
            System.out.println("Do you wish to play again?");
            answer = input.nextLine().toUpperCase();
            if(answer.equals("Y")){
                gameOver = true;
                break;
            } else if (answer.equals("N")) {
                gameOver = false;
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
        return gameOver;
    }
}