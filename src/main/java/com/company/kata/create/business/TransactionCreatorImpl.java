package com.company.kata.create.business;

import com.company.kata.create.api.TransactionCreator;
import com.company.kata.model.Transaction;
import com.company.kata.model.TransactionType;

import java.time.LocalDate;

import static com.company.kata.model.TransactionType.EXPENSE;

public class TransactionCreatorImpl implements TransactionCreator {
    @Override
    public Transaction create(TransactionType type, LocalDate date, String description, long amount) {
        return Transaction.builder()
                .amount(type.equals(EXPENSE) ? -amount : amount)
                .transactionType(type)
                .date(date)
                .description(description)
                .build();
    }
}
