package com.chandler.mathgame;

public class JokeQuestion extends Question{

    @Override
    public void showQuestion(){
        System.out.println("How many coders does it take to screw in a light bulb?");
    }

    @Override
    public boolean checkAnswer(int response){
        return true;
    }
}
