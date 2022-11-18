package com.company.kata.parse.business;

import com.company.kata.model.CommandType;
import com.company.kata.create.business.TransactionCreatorImpl;
import com.company.kata.calculate.api.BalanceCalculator;
import com.company.kata.create.api.TransactionCreator;
import com.company.kata.calculate.business.BalanceCalculatorImpl;
import com.company.kata.model.*;
import com.company.kata.parse.api.CommandParser;
import com.company.kata.parse.api.CommandTypeParser;
import com.company.kata.parse.api.DateParser;
import com.company.kata.parse.api.PeriodTypeParser;

import java.time.LocalDate;

import static com.company.kata.model.CommandType.NOT_A_COMMAND;
import static com.company.kata.model.TransactionType.EXPENSE;
import static com.company.kata.model.TransactionType.INCOME;

/**
 * The interface Command parser.
 */
public class CommandParserImpl implements CommandParser {

    private final CommandTypeParser commandTypeParser;
    private final PeriodTypeParser periodTypeParser;
    private final DateParser dateParser;
    private final BalanceCalculator balanceCalculator;
    private final TransactionCreator transactionCreator;

    public CommandParserImpl() {
        this.balanceCalculator = new BalanceCalculatorImpl();
        this.transactionCreator = new TransactionCreatorImpl();
        this.commandTypeParser = new CommandTypeParserImpl();
        this.dateParser = new DateParserImpl();
        this.periodTypeParser = new PeriodTypeParserImpl();
    }


    /**
     * Parse string.
     *
     * @param line the line
     * @return the string
     */
    public String parse(String line, Balance balance) {
        String[] words = line.split(" ");

        CommandType command = commandTypeParser.parse(words[0]);
        try {
            if (NOT_A_COMMAND.equals(command)) {
                return command.name();
            } else if (CommandType.EXPENSE.equals(command) || CommandType.INCOME.equals(command)) {
                return addTransaction(balance, words, command);
            } else if (CommandType.PRINT.equals(command)) {
                return print(balance, words);
            } else if (words[0].equalsIgnoreCase(CommandType.EXIT.name())) {
                System.exit(0);
            }
        } catch (NotValidDateFormatException e) {
            return "NOT_GOOD_DATE_FORMAT";
        } catch (NumberFormatException e) {
            return "NOT_A_VALID_AMOUNT";
        }
        return NOT_A_COMMAND.name();
    }

    private String addTransaction(Balance balance, String[] words, CommandType command) {
        balance.getBalanceSheet().add(create(words, command));
        return "";
    }

    private String print(Balance balance, String[] words) {
        PeriodType periodType = periodTypeParser.parse(words[1]);
        LocalDate date = dateParser.parse(words[2], periodType);
        return balanceCalculator.calculate(balance, periodType, date);
    }

    private Transaction create(String[] words, CommandType command) {
        return transactionCreator.create(getType(command), dateParser.parse(words[1]), words[2], Long.parseLong(words[3]));
    }

    private TransactionType getType(CommandType command) {
        return command.equals(CommandType.EXPENSE) ? EXPENSE : INCOME;
    }
}
