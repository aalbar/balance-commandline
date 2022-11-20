package com.company.kata.run.business;

import com.company.kata.create.api.BalanceManager;
import com.company.kata.create.business.BalanceManagerImpl;
import com.company.kata.model.Balance;
import com.company.kata.model.exception.NotValidDateFormatException;
import com.company.kata.model.type.CommandType;
import com.company.kata.parse.api.CommandTypeParser;
import com.company.kata.parse.business.CommandTypeParserImpl;
import com.company.kata.print.api.BalancePrinter;
import com.company.kata.print.business.BalancePrinterImpl;
import com.company.kata.run.api.CommandRunner;

import static com.company.kata.model.type.CommandType.NOT_A_COMMAND;

/**
 * The interface Command parser.
 */
public class CommandRunnerImpl implements CommandRunner {


    private final CommandTypeParser commandTypeParser;
    private final BalanceManager balanceManager;
    private final BalancePrinter balancePrinter;


    /**
     * Instantiates a new Command runner.
     */
    public CommandRunnerImpl() {
        this.commandTypeParser = new CommandTypeParserImpl();
        this.balanceManager = new BalanceManagerImpl();
        this.balancePrinter = new BalancePrinterImpl();
    }

    /**
     * Parse string.
     *
     * @param line the line
     * @return the string
     */
    public String run(String line, Balance balance) {
        String[] words = line.split(" ");


        CommandType command = commandTypeParser.parse(words[0]);
        try {
            return switch (command) {
                case EXPENSE, INCOME -> balanceManager.addLine(balance, command, words);
                case PRINT -> balancePrinter.print(balance, words);
                case EXIT -> exit();
                default -> NOT_A_COMMAND.name();
            };
        } catch (NotValidDateFormatException e) {
            return "NOT_GOOD_DATE_FORMAT";
        } catch (NumberFormatException e) {
            return "NOT_A_VALID_AMOUNT";
        }
    }

    private String exit() {
        System.exit(0);
        return "";
    }


}
