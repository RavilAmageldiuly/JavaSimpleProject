package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private String name;
    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Quiz loadFromFile(String fileName) throws FileNotFoundException, InvalidFileFormatException, IOException {
        int i = fileName.lastIndexOf(".");
        if (i < 0 || !fileName.substring(i + 1).equals("txt")) {
            throw new InvalidFileFormatException("Invalid File Format!");
        }

        setName(fileName.substring(0, i));

        File quizFile = new File("C:\\Users\\rvlc1\\Desktop\\" + fileName);
        BufferedReader br = new BufferedReader(new FileReader(quizFile));

        String line;

        while((line = br.readLine()) != null) {
            if (line.contains("{blank}")) {
                FillIn fillInQuestion = new FillIn();
                fillInQuestion.setDescription(line);
                fillInQuestion.setCorrectAnswer(br.readLine());
                addQuestion(fillInQuestion);
            } else if (line.length() == 0) {
                continue;
            } else {
                Test testQuestion = new Test();
                testQuestion.setDescription(line);
                String temporaryCorrectAns = br.readLine();
                String[] tempOptions = new String[4];
                for (int j = 0; j < 4; j++) {
                    tempOptions[j] = br.readLine();
                }
                testQuestion.setOptions(tempOptions);
                testQuestion.setCorrectAnswerLabel(temporaryCorrectAns);
                testQuestion.setCorrectAnswer(testQuestion.getCorrectAnswerLabel());
                addQuestion(testQuestion);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void start() {
        double correctAnswers = 0.0;
        double questionNum = (double) questions.size();
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("Welcome to the " + getName() + " quiz!");
        System.out.println("=======================================================================");
        int count = 1;
        for (Question q: questions) {
            System.out.println(count + ". " + q.toString());
            count++;
            System.out.println("--------------------------------------");
            System.out.print("Enter the answer: ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals(q.getCorrectAnswer())) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        }
        System.out.println("Your score is: " + String.format("%.2f", (correctAnswers / questionNum * 100)) + "%");
    }
}
