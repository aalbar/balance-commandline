package com.company.kata.calculate.business;

import com.company.kata.calculate.api.BalanceCalculator;
import com.company.kata.model.Balance;
import com.company.kata.model.Transaction;
import com.company.kata.model.type.PeriodType;

import java.time.LocalDate;
import java.util.function.BiPredicate;

import static com.company.kata.model.type.PeriodType.NOT_A_PERIOD;

/**
 * The type Balance calculator.
 */
public class BalanceCalculatorImpl implements BalanceCalculator {
    /**
     * Print string.
     *
     * @param balance the balance
     * @param period  the period
     * @param date    the date
     * @return the string
     */
    @Override
    public String calculate(Balance balance, PeriodType period, LocalDate date) {
        return switch (period) {
            case YEAR -> calculate(balance, date, yearSelector());
            case MONTH -> calculate(balance, date, monthSelector());
            case DAY -> calculate(balance, date, daySelector());
            default -> NOT_A_PERIOD.name();
        };
    }

    private String calculate(Balance balance, LocalDate date, BiPredicate<Transaction, LocalDate> selector) {
        return balance.getBalanceSheet().stream().filter(transaction -> selector.test(transaction, date))
                .map(Transaction::getAmount)
                .reduce(0L, Long::sum).toString();
    }

    private BiPredicate<Transaction, LocalDate> yearSelector() {
        return (transaction, date) -> transaction.getDate().getYear() == date.getYear();
    }

    private BiPredicate<Transaction, LocalDate> monthSelector() {
        return (transaction, date) -> transaction.getDate().getYear() == date.getYear()
                && transaction.getDate().getMonthValue() == date.getMonthValue();
    }

    private BiPredicate<Transaction, LocalDate> daySelector() {
        return (transaction, date) -> transaction.getDate().equals(date);
    }
}
