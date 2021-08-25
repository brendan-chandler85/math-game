package com.chandler.mathgame;

public class Question {
    protected int value1;
    protected int value2;
    protected String operator;
    private int answer;

    public void showQuestion(){
        if((value2 > value1) && (operator.equals("-"))){
            System.out.printf("What is %d %s %d ?\n", value2, operator, value1);
        } else if(operator.equals("/")){
            answer = value1 * value2;
            System.out.printf("What is %d %s %d ?\n", answer, operator, value2);
        } else {
            System.out.printf("What is %d %s %d ?\n", value1, operator, value2);
        }
    }

    public boolean checkAnswer(int response){
        switch(operator){
            case "+":
                answer = value1 + value2;
                break;
            case "-":
                if(value2 > value1){
                    answer = value2 - value1;
                } else {
                    answer = value1 - value2;
                }
                break;
            case "*":
                answer = value1 * value2;
                break;
            case "/":
                answer = value1 * value2;
                answer /= value2;
        }

        if(response == answer){
            System.out.println("  Yes!");
            return true;
        } else {
            System.out.printf("  No, the answer is %d.\n", answer);
            return false;
        }
    }
}
