package com.company.kata.main;

import com.company.kata.model.Balance;
import com.company.kata.run.api.CommandRunner;
import com.company.kata.run.business.CommandRunnerImpl;

import java.util.Scanner;

/**
 * The type Command line.
 */
public class CommandLine {


    public static void main(String[] args) {
        CommandRunner commandRunner = new CommandRunnerImpl();
        Balance balance = new Balance();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String response = commandRunner.run(sc.nextLine(), balance);
            if (!"".equals(response)) {
                System.out.println(response);
            }
        }
    }
}
