package com.readability_score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Text {
    protected final String filePath;
    protected String[] text;
    protected final StringBuilder fromFileToText = new StringBuilder();
    protected int symbols = 0;
    protected int words = 0;
    protected int sentences = 0;
    protected int syllables = 0;
    protected int polysyllables = 0;

    public Text(String filePath) {
        this.filePath = filePath;
    }

    public boolean checkText() {
        //get the text from file
        File textFile = new File(filePath);
        try (Scanner scan = new Scanner(textFile)) {
            while (scan.hasNext()) {
                fromFileToText.append(scan.nextLine());
            }
            findValuesOfVariables();
            return true;
        }catch (FileNotFoundException e){
            return false;
        }
    }

    public void findValuesOfVariables() {
        //output the text
        System.out.println("The text is:\n" + fromFileToText.toString() + "\n");
        text = fromFileToText.toString().split("[!?.]");
        words = countWords();
        System.out.println("Words: " + words);
        sentences = text.length;
        System.out.println("Sentences: " + sentences);
        symbols = countSymbols();
        System.out.println("Characters: " + symbols);
        syllables = countSyllables();
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
    }

    public int countSymbols() {
        String symbols = fromFileToText.toString().replace(" ", "")
                .replace("\t", "").replace("\n", "");
        return symbols.length();
    }

    public int countWords() {
        int count = 0;
        for (String i : text) {
            String[] wordsOfSentence = i.trim().split(" ");
            count += wordsOfSentence.length;
        }
        return count;
    }

    public int countSyllables() {
        int countPolysyllables = 0;
        int countSyllables = 0;
        for (String i : text) {
            String[] wordsOfSentence = i.toLowerCase().trim().split(" ");
            for (String s : wordsOfSentence) {
                for (int k = 0; k < s.length(); k++) {
                    if (String.valueOf(s.charAt(k)).matches("[aoiuye]")) {
                        if (k > 0 && String.valueOf(s.charAt(k - 1)).matches("[aoiuye]") || (s.charAt(k) == 'e' && k == s.length() - 1)) {
                            continue;
                        }
                        countSyllables++;
                        countPolysyllables++;
                    }
                }
                if (countPolysyllables > 2) {
                    polysyllables++;
                }
                countPolysyllables = 0;
                if (countSyllables == 0) {
                    countSyllables++;
                }
                syllables += countSyllables;
                countSyllables = 0;
            }
        }
        return syllables;
    }
}
