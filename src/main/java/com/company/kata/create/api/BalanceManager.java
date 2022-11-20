package com.company.kata.create.api;

import com.company.kata.model.Balance;
import com.company.kata.model.type.CommandType;

/**
 * The interface Transaction creator.
 */
public interface BalanceManager {


    /**
     * Add transaction string.
     *
     * @param balance the balance
     * @param command the command
     * @param words   the words
     * @return the string
     */
    String addLine(Balance balance, CommandType command, String[] words);
}
