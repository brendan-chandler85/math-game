package com.chandler.mathgame;

import java.util.Random;

public class MathQuestion extends Question {

    public MathQuestion(Random rand){
        value1 = rand.nextInt(20);
        value2 = rand.nextInt(20);
        int opCode = rand.nextInt(4);

        if (opCode == 0){
            operator = "+";
        } else if (opCode == 1){
            operator = "-";
        }else if (opCode == 2){
            operator = "*";
        } else if (opCode == 3){
            operator = "/";
            if (value2 == 0){
                value2++;
            }
        }
    }

    // Constructor used only for testing
    public MathQuestion(int v1, int v2, String op){
        value1 = v1;
        value2 = v2;
        operator = op;
    }

}
