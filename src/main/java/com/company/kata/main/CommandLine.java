package com.company.kata.main;

import com.company.kata.model.Balance;
import com.company.kata.parse.api.CommandParser;
import com.company.kata.parse.business.CommandParserImpl;

import java.util.Scanner;

/**
 * The type Command line.
 */
public class CommandLine {


    public static void main(String[] args) {

        CommandParser commandParser = new CommandParserImpl();
        Balance balance = new Balance();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String response = commandParser.parse(sc.nextLine(), balance);
            if (!"".equals(response)) {
                System.out.println(response);
            }
        }
    }
}
