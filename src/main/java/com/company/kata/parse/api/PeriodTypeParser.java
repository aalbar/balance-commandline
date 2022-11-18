package com.company.kata.parse.api;

import com.company.kata.model.PeriodType;

/**
 * The interface Period type parser.
 */
public interface PeriodTypeParser {

    /**
     * Parse period type.
     *
     * @param text the text
     * @return the period type
     */
    PeriodType parse(String text);
}
