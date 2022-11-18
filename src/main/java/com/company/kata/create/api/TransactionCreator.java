package com.company.kata.create.api;

import com.company.kata.model.Transaction;
import com.company.kata.model.TransactionType;

import java.time.LocalDate;

/**
 * The interface Transaction creator.
 */
public interface TransactionCreator {

    /**
     * Add string.
     *
     * @param type        the type
     * @param date        the date
     * @param description the description
     * @param amount      the amount
     * @return the string
     */
    Transaction create(TransactionType type, LocalDate date, String description, long amount);
}
