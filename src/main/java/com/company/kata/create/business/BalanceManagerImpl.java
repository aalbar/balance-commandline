package com.company.kata.create.business;

import com.company.kata.create.api.BalanceManager;
import com.company.kata.model.Balance;
import com.company.kata.model.Transaction;
import com.company.kata.model.type.CommandType;
import com.company.kata.model.type.TransactionType;
import com.company.kata.parse.api.DateParser;
import com.company.kata.parse.business.DateParserImpl;

import java.time.LocalDate;

import static com.company.kata.model.type.TransactionType.EXPENSE;
import static com.company.kata.model.type.TransactionType.INCOME;

public class BalanceManagerImpl implements BalanceManager {

    private final DateParser dateParser;

    public BalanceManagerImpl() {
        dateParser = new DateParserImpl();
    }

    public String addLine(Balance balance, CommandType command, String[] words) {
        balance.getBalanceSheet().add(create(words, command));
        return "";
    }

    private Transaction create(String[] words, CommandType command) {
        return create(convert(command), dateParser.parse(words[1]), words[2], Long.parseLong(words[3]));
    }

    private Transaction create(TransactionType type, LocalDate date, String description, long amount) {
        return Transaction.builder()
                .amount(type.equals(EXPENSE) ? -amount : amount)
                .transactionType(type)
                .date(date)
                .description(description)
                .build();
    }

    private TransactionType convert(CommandType command) {
        return command.equals(CommandType.EXPENSE) ? EXPENSE : INCOME;
    }
}
