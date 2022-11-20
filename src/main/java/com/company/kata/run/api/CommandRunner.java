package com.company.kata.run.api;

import com.company.kata.model.Balance;

/**
 * The interface Command parser.
 */
public interface CommandRunner {

    /**
     * Parse string.
     *
     * @param line    the line
     * @param balance the balance
     * @return the string
     */
    String run(String line, Balance balance);
}
