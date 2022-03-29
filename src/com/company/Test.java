package com.company;

import java.util.ArrayList;

public class Test extends Question {

    private String[] options;
    private int numOfOptions = 4;
    private ArrayList<String> labels;
    private String correctAnswerLabel;

    public Test() {
        labels = new ArrayList<>();
        labels.add("A");
        labels.add("B");
        labels.add("C");
        labels.add("D");
    }

    public void setCorrectAnswerLabel(String correctAnswer) {
        int index = 0;
        for (int i = 0; i < numOfOptions; i++) {
            if (options[i].equals(correctAnswer)) {
                index = i;
            }
        }
        switch (index) {
            case 0 -> correctAnswerLabel = "A";
            case 1 -> correctAnswerLabel = "B";
            case 2 -> correctAnswerLabel = "C";
            case 3 -> correctAnswerLabel = "D";
        }
    }

    public String getCorrectAnswerLabel() {
        return correctAnswerLabel;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getOptionAt(int index) {
        return options[index];
    }

    @Override
    public String toString() {
        StringBuffer multipleChoice = new StringBuffer();
        multipleChoice.append(super.getDescription() + "\n");
        for (int i = 0; i < numOfOptions; i++) {
            multipleChoice.append(labels.get(i) + ") " + options[i] + "\n");
        }
        return multipleChoice.toString();
    }

}
