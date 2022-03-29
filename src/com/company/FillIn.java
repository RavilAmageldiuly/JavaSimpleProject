package com.company;

public class FillIn extends Question {
    @Override
    public String toString() {
        return super.getDescription().replace("{blank}", "_____");
    }
}
