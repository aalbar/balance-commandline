package com.company.kata.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Balance.
 */

public class Balance {

    public Balance() {
        balanceSheet = new ArrayList<>();
    }

    @Getter
    private List<Transaction> balanceSheet;


}
