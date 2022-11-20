package com.company.kata.parse.api;

import com.company.kata.model.type.CommandType;

public interface CommandTypeParser {

    CommandType parse(String text);
}
