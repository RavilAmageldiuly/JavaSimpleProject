package com.company;

public class InvalidFileFormatException extends Exception{
    public InvalidFileFormatException(String errorMessage) {
        super(errorMessage);
    }
}
