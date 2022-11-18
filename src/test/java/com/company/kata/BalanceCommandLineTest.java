package com.company.kata;

import com.company.kata.model.Balance;
import com.company.kata.model.CommandType;
import com.company.kata.model.TransactionType;
import com.company.kata.parse.api.CommandParser;
import com.company.kata.parse.business.CommandParserImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceCommandLineTest {


    @Test
    void should_add_income_transaction() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();

        //When
        commandParser.parse("INCOME 2020/01/01 salary 500", balance);

        //Then
        assertThat(balance.getBalanceSheet().get(0).getAmount()).isEqualByComparingTo(500L);
        assertThat(balance.getBalanceSheet().get(0).getTransactionType()).isEqualByComparingTo(TransactionType.INCOME);

    }

    @Test
    void should_add_expense_transaction() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();
        //When
        commandParser.parse("EXPENSE 2020/01/01 coffee 5", balance);

        //Then
        assertThat(balance.getBalanceSheet().get(0).getAmount()).isEqualByComparingTo(-5L);
        assertThat(balance.getBalanceSheet().get(0).getTransactionType()).isEqualByComparingTo(TransactionType.EXPENSE);

    }


    @Test
    void should_return_message_when_command_is_not_transaction() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();

        //When
        String result = commandParser.parse("Test 2020/01/01 salary 500", balance);

        //Then
        assertThat(result).isEqualTo(CommandType.NOT_A_COMMAND.name());
    }


    @Test
    void should_print_year_balance() {


        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();
        commandParser.parse("INCOME 2020/01/01 salary 500", balance);
        commandParser.parse("EXPENSE 2020/02/01 coffee 5", balance);
        commandParser.parse("EXPENSE 2020/01/07 beer 10", balance);
        commandParser.parse("INCOME 2021/01/01 bonus 200", balance);

        //When
        String result = commandParser.parse("PRINT YEAR 2020", balance);


        //Then
        assertThat(result).isEqualTo("485");
    }

    @Test
    void should_print_month_balance() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();
        commandParser.parse("INCOME 2020/01/01 salary 500", balance);
        commandParser.parse("EXPENSE 2020/01/10 coffee 10", balance);
        commandParser.parse("EXPENSE 2020/01/07 beer 15", balance);
        commandParser.parse("EXPENSE 2021/02/01 beer 20", balance);

        //When
        String result = commandParser.parse("PRINT MONTH 2020/01", balance);


        //Then
        assertThat(result).isEqualTo("475");
    }

    @Test
    void should_print_day_balance() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();
        commandParser.parse("INCOME 2018/11/15 salary 500", balance);
        commandParser.parse("EXPENSE 2018/11/15 coffee 10", balance);
        commandParser.parse("EXPENSE 2018/11/16 beer 15", balance);
        commandParser.parse("EXPENSE 2018/11/14 beer 20", balance);

        //When
        String result = commandParser.parse("PRINT DAY 2018/11/15", balance);


        //Then
        assertThat(result).isEqualTo("490");
    }

    @Test
    void should_not_command() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();

        //When
        String result = commandParser.parse("POTATO DAY 2018/11/15", balance);

        //Then
        assertThat(result).isEqualTo(CommandType.NOT_A_COMMAND.name());
    }

    @Test
    void should_print_not_period_command() {

        //Given
        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();

        //When
        String result = commandParser.parse("PRINT POTATO 2018/11/15", balance);

        //Then
        assertThat(result).isEqualTo("NOT_GOOD_DATE_FORMAT");
    }


}
