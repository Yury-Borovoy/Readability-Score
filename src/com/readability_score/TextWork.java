package com.readability_score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextWork {
    private final String filePath;
    private String[] text;
    private final StringBuilder fromFileToText = new StringBuilder();
    private int symbols;
    private int words;
    private int sentences;
    private double score;

    public TextWork(String filePath) {
        this.filePath = filePath;
    }

    public void goWork() {
        //get the text from file
        File textFile = new File(filePath);
        try (Scanner scan = new Scanner(textFile)) {
            while (scan.hasNext()) {
                fromFileToText.append(scan.nextLine());
            }
            //output the text
            System.out.println("The text is:\n" + fromFileToText.toString());
            text = fromFileToText.toString().split("[!?.]");
            //get quantity of words in the text
            words = countWords();
            System.out.println("words: " + words);
            //get quantity of sentences
            sentences = text.length;
            System.out.println("Sentences: " + sentences);
            //get quantity of symbols in the text
            symbols = countSymbols();
            System.out.println("Characters: " + symbols);
            //get the score of the text
            score = estimateScore();
            System.out.printf("The score is: %.2f %n", score);
            //get the difficulty of the text
            System.out.println("This text should be understood by " + estimateDifficulty() + " year olds.");
        }catch (FileNotFoundException e){
            System.out.println("Ohh");
        }
    }

    public int countSymbols() {
        String symbols = fromFileToText.toString().replace(" ", "").replace("\t", "").replace("\n", "");
        return symbols.length();
    }

    public int countWords() {
        int count = 0;
        for (String i : text) {
            String[] sentence = i.trim().split(" ");
            count += sentence.length;
        }
        return count;
    }

    public double estimateScore() {
        return ((4.71 *  ((double)symbols / (double)words)) + (0.5 * ((double) words / (double) sentences))) - 21.43;
    }

    public String estimateDifficulty() {
        switch((int)Math.ceil(score)){
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "15-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            case 14:
                return "24+";
            default:
                return "sorry";

        }
    }
}
