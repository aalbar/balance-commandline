package com.company.kata.parse.api;

import com.company.kata.model.CommandType;

public interface CommandTypeParser {

    CommandType parse(String text);
}
