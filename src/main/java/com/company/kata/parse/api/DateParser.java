package com.company.kata.parse.api;

import com.company.kata.model.type.PeriodType;

import java.time.LocalDate;

/**
 * The interface Date parser.
 */
public interface DateParser {


    /**
     * Parse local date.
     *
     * @param text the text
     * @return the local date
     */
    LocalDate parse(String text);

    /**
     * Parse local date.
     *
     * @param text       the text
     * @param periodType the period type
     * @return the local date
     */
    LocalDate parse(String text, PeriodType periodType);


}
