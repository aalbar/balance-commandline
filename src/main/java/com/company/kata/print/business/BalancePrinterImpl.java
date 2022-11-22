package com.company.kata.print.business;

import com.company.kata.calculate.api.BalanceCalculator;
import com.company.kata.calculate.business.BalanceCalculatorImpl;
import com.company.kata.model.Balance;
import com.company.kata.model.type.PeriodType;
import com.company.kata.parse.api.DateParser;
import com.company.kata.parse.api.PeriodTypeParser;
import com.company.kata.parse.business.DateParserImpl;
import com.company.kata.parse.business.PeriodTypeParserImpl;
import com.company.kata.print.api.BalancePrinter;

import java.time.LocalDate;

import static com.company.kata.model.type.PeriodType.NOT_A_PERIOD;

/**
 * The type Balance printer.
 */
public class BalancePrinterImpl implements BalancePrinter {

    private final PeriodTypeParser periodTypeParser;
    private final DateParser dateParser;
    private final BalanceCalculator balanceCalculator;

    /**
     * Instantiates a new Balance printer.
     */
    public BalancePrinterImpl() {
        this.balanceCalculator = new BalanceCalculatorImpl();
        this.dateParser = new DateParserImpl();
        this.periodTypeParser = new PeriodTypeParserImpl();
    }

    /**
     * Print string.
     *
     * @param balance the balance
     * @param words   the words
     * @return the string
     */
    public String print(Balance balance, String[] words) {
        PeriodType periodType = periodTypeParser.parse(words[1]);
        if (NOT_A_PERIOD.equals(periodType)) return NOT_A_PERIOD.name();
        LocalDate date = dateParser.parse(words[2], periodType);
        return balanceCalculator.calculate(balance, periodType, date);
    }

}
