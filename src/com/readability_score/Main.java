package com.readability_score;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split("[!?.]");
        int countOfWords;
        ArrayList<Integer> wordsInSentence = new ArrayList<>();
        for (String sentence : text) {
            String[] array = sentence.split(" ");
            countOfWords = array.length;
            wordsInSentence.add(countOfWords);
        }
        int difficultyOfText = 0;
        for (Integer integer : wordsInSentence) {
            difficultyOfText += integer;
        }

        if (difficultyOfText / wordsInSentence.size() <=10) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }
}