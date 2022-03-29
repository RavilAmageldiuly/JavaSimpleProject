package com.company;

public abstract class Question {
    private String description;
    private String correctAnswer;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
}
