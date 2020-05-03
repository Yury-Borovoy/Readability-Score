package com.readability_score;

import java.util.Scanner;

public class Score extends Text{

    protected double scoreARI = 0.0;
    protected double scoreFK = 0.0;
    protected double scoreSMOG = 0.0;
    protected double scoreCL = 0.0;

    public Score(String filePath) {
        super(filePath);
    }
    public void goScore() {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch(input) {
            case "ARI":
                scoreARI = goScoreARI();
                System.out.println("Automated Readability Index: " + scoreARI + "(about " + estimateDifficulty(scoreARI) + " year olds).");
                break;
            case "FK":
                scoreFK = goScoreFK();
                System.out.println("Flesch–Kincaid readability tests: " + scoreFK + "(about " + estimateDifficulty(scoreFK) + " year olds).");
                break;
            case "SMOG":
                scoreSMOG = goScoreSMOG();
                System.out.println("Simple Measure of Gobbledygook: " + scoreSMOG + "(about " + estimateDifficulty(scoreSMOG) + " year olds).");
                break;
            case "CL":
                scoreCL = goScoreCL();
                System.out.println("Coleman–Liau index: " + scoreCL + "(about " + estimateDifficulty(scoreCL) + " year olds).");
                break;
            case "all":
                scoreARI = goScoreARI();
                scoreFK = goScoreFK();
                scoreSMOG = goScoreSMOG();
                scoreCL = goScoreCL();
                System.out.println("Automated Readability Index: " + scoreARI + "(about " + estimateDifficulty(scoreARI) + " year olds).");
                System.out.println("Flesch–Kincaid readability tests: " + scoreFK + "(about " + estimateDifficulty(scoreFK) + " year olds).");
                System.out.println("Simple Measure of Gobbledygook: " + scoreSMOG + "(about " + estimateDifficulty(scoreSMOG) + " year olds).");
                System.out.println("Coleman–Liau index: " + scoreCL + "(about " + estimateDifficulty(scoreCL) + " year olds).\n");
                System.out.println("This text should be understood in average by " + countAverageScore() + " year olds.");
                break;
            default:
                break;
        }
    }

    public double goScoreARI() {
        double ari = ((4.71 *  ((double)symbols / (double)words)) + (0.5 * ((double) words / (double) sentences))) - 21.43;
        ari = Math.round(ari * 100d) / 100d;
        return ari;
    }

    public double goScoreFK() {
        double fk = 0.39 * ((double)words / (double)sentences) + 11.8 * ((double) syllables / (double) words) - 15.59;
        fk = Math.round(fk * 100d) / 100d;
        return fk;
    }

    public double goScoreSMOG() {
        double smog = 1.043 * Math.sqrt(polysyllables * (30d / sentences)) + 3.1291;
        smog = Math.round(smog * 100d) / 100d;
        return smog;
    }

    public double goScoreCL() {
        double averageOfCharacters;
        double averageOfSentences;

        averageOfCharacters = ((double)symbols / words) * 100d;
        System.out.println(averageOfCharacters);

        averageOfSentences = ((double)sentences / words) * 100d;
        System.out.println(averageOfSentences);

        double cl = 0.0588 * averageOfCharacters - 0.296 * averageOfSentences - 15.8;
        cl = Math.round(cl * 100d) / 100d;
        return cl;
    }

    public String estimateDifficulty(double score) {
        switch((int)Math.ceil(score)){
            case 1:
                return "6";
            case 2:
                return "7";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "11";
            case 6:
                return "12";
            case 7:
                return "13";
            case 8:
                return "14";
            case 9:
                return "15";
            case 10:
                return "16";
            case 11:
                return "17";
            case 12:
                return "18";
            case 13:
                return "24";
            case 14:
                return "24+";
            default:
                return "sorry";

        }
    }

    public double countAverageScore() {
        return (scoreARI + scoreFK + scoreSMOG + scoreCL) / 4;
    }
}