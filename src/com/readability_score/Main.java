package com.readability_score;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        if (text.length() <=100) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }
}
