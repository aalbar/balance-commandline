package com.company.kata.calculate.api;

import com.company.kata.model.Balance;
import com.company.kata.model.type.PeriodType;

import java.time.LocalDate;

/**
 * The interface Transaction printer.
 */
public interface BalanceCalculator {

    /**
     * Print string.
     *
     * @param balance the balance
     * @param period  the period
     * @param date    the date
     * @return the string
     */
    String calculate(Balance balance, PeriodType period, LocalDate date);
}
