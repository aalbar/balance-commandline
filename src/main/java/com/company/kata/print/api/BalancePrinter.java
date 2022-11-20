package com.company.kata.print.api;

import com.company.kata.model.Balance;

public interface BalancePrinter {
    String print(Balance balance, String[] words);
}
