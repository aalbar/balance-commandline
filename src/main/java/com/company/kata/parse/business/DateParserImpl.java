package com.company.kata.parse.business;

import com.company.kata.model.exception.NotValidDateFormatException;
import com.company.kata.model.type.PeriodType;
import com.company.kata.parse.api.DateParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The type Date parser.
 */
public class DateParserImpl implements DateParser {


    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Override
    public LocalDate parse(String text) {
        return parse(text, PeriodType.DAY);
    }

    @Override
    public LocalDate parse(String text, PeriodType periodType) {
        try {
            return switch (periodType) {
                case DAY -> LocalDate.parse(text, dateFormatter);
                case MONTH ->
                        LocalDate.of(Integer.parseInt(text.substring(0, 4)), Integer.parseInt(text.substring(5, 7)), 1);
                case YEAR -> LocalDate.of(Integer.parseInt(text), 1, 1);
                default -> throw new NotValidDateFormatException();
            };
        } catch (NumberFormatException | DateTimeParseException |
                 IndexOutOfBoundsException e) {
            throw new NotValidDateFormatException();
        }

    }


}
