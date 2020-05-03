package com.readability_score;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            Score score = new Score(args[0]);
            if (score.checkText()) {
                score.goScore();
            } else {
                System.out.println("Your file is empty.");
            }
        }else {
            System.out.println("You didn't input the filepath.");
        }
    }
}
