package com.readability_score;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            TextWork textWork = new TextWork(args[0]);
            textWork.goWork();
        }else {
            System.out.println("Sorry");
        }
    }
}