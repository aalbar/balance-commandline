package com.company.kata.parse.api;

import com.company.kata.model.Balance;

/**
 * The interface Command parser.
 */
public interface CommandParser {

    /**
     * Parse string.
     *
     * @param line    the line
     * @param balance the balance
     * @return the string
     */
    String parse(String line, Balance balance);
}
