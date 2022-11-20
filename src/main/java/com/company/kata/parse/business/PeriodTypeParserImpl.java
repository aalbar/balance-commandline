package com.company.kata.parse.business;

import com.company.kata.model.type.PeriodType;
import com.company.kata.parse.api.PeriodTypeParser;

/**
 * The type Period type parser.
 */
public class PeriodTypeParserImpl implements PeriodTypeParser {
    @Override
    public PeriodType parse(String text) {
        for (PeriodType periodType : PeriodType.values()) {
            if (periodType.name().equals(text)) {
                return periodType;
            }
        }
        return PeriodType.NOT_A_PERIOD;
    }
}
