package com.company;

import java.io.IOException;

public class QuizMaker {

    public static void main(String[] args) throws InvalidFileFormatException, IOException {
        Quiz quiz = new Quiz();
        quiz.loadFromFile("JavaQuiz.txt");
        quiz.start();
    }
}
