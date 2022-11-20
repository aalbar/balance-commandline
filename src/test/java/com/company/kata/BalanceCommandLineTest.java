package com.company.kata;

import com.company.kata.model.Balance;
import com.company.kata.model.type.CommandType;
import com.company.kata.model.type.TransactionType;
import com.company.kata.run.api.CommandRunner;
import com.company.kata.run.business.CommandRunnerImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceCommandLineTest {


    @Test
    void should_add_income_transaction() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();

        //When
        CommandRunner.run("INCOME 2020/01/01 salary 500", balance);

        //Then
        assertThat(balance.getBalanceSheet().get(0).getAmount()).isEqualByComparingTo(500L);
        assertThat(balance.getBalanceSheet().get(0).getTransactionType()).isEqualByComparingTo(TransactionType.INCOME);

    }

    @Test
    void should_add_expense_transaction() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();
        //When
        CommandRunner.run("EXPENSE 2020/01/01 coffee 5", balance);

        //Then
        assertThat(balance.getBalanceSheet().get(0).getAmount()).isEqualByComparingTo(-5L);
        assertThat(balance.getBalanceSheet().get(0).getTransactionType()).isEqualByComparingTo(TransactionType.EXPENSE);

    }


    @Test
    void should_return_message_when_command_is_not_transaction() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();

        //When
        String result = CommandRunner.run("Test 2020/01/01 salary 500", balance);

        //Then
        assertThat(result).isEqualTo(CommandType.NOT_A_COMMAND.name());
    }


    @Test
    void should_print_year_balance() {


        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();
        CommandRunner.run("INCOME 2020/01/01 salary 500", balance);
        CommandRunner.run("EXPENSE 2020/02/01 coffee 5", balance);
        CommandRunner.run("EXPENSE 2020/01/07 beer 10", balance);
        CommandRunner.run("INCOME 2021/01/01 bonus 200", balance);

        //When
        String result = CommandRunner.run("PRINT YEAR 2020", balance);


        //Then
        assertThat(result).isEqualTo("485");
    }

    @Test
    void should_print_month_balance() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();
        CommandRunner.run("INCOME 2020/01/01 salary 500", balance);
        CommandRunner.run("EXPENSE 2020/01/10 coffee 10", balance);
        CommandRunner.run("EXPENSE 2020/01/07 beer 15", balance);
        CommandRunner.run("EXPENSE 2021/02/01 beer 20", balance);

        //When
        String result = CommandRunner.run("PRINT MONTH 2020/01", balance);


        //Then
        assertThat(result).isEqualTo("475");
    }

    @Test
    void should_print_day_balance() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();
        CommandRunner.run("INCOME 2018/11/15 salary 500", balance);
        CommandRunner.run("EXPENSE 2018/11/15 coffee 10", balance);
        CommandRunner.run("EXPENSE 2018/11/16 beer 15", balance);
        CommandRunner.run("EXPENSE 2018/11/14 beer 20", balance);

        //When
        String result = CommandRunner.run("PRINT DAY 2018/11/15", balance);


        //Then
        assertThat(result).isEqualTo("490");
    }

    @Test
    void should_not_command() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();

        //When
        String result = CommandRunner.run("POTATO DAY 2018/11/15", balance);

        //Then
        assertThat(result).isEqualTo(CommandType.NOT_A_COMMAND.name());
    }

    @Test
    void should_print_not_period_command() {

        //Given
        CommandRunner CommandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();

        //When
        String result = CommandRunner.run("PRINT POTATO 2018/11/15", balance);

        //Then
        assertThat(result).isEqualTo("NOT_GOOD_DATE_FORMAT");
    }


}
