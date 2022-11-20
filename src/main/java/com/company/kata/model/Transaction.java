package com.company.kata.model;


import com.company.kata.model.type.TransactionType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Transaction {

    private long amount;
    private LocalDate date;
    private String description;
    private TransactionType transactionType;
}
