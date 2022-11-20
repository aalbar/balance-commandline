package com.company.kata.parse.business;

import com.company.kata.model.type.CommandType;
import com.company.kata.parse.api.CommandTypeParser;

/**
 * The type Command type parser.
 */
public class CommandTypeParserImpl implements CommandTypeParser {
    @Override
    public CommandType parse(String text) {

        for (CommandType commandType : CommandType.values()) {
            if (commandType.name().equals(text)) {
                return commandType;
            }
        }
        return CommandType.NOT_A_COMMAND;
    }
}
