package com.company.kata.model;

/**
 * The type Not valid date format.
 */
public class NotValidDateFormatException extends RuntimeException {

    public NotValidDateFormatException() {
        super("Date format is not expected");
    }
}
