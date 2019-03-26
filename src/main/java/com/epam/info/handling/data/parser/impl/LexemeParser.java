package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;

public class LexemeParser extends AbstractParser {
    private static final String MATCHING_REGEXP = "\\w+|-|,|;|:|\\.{3}|\\.|!|\\?|\\(|\\)";

    @Override
    public Component parse(String text) {
        if (text.matches(MATCHING_REGEXP)) {
            return Lexeme.word(text);
        } else {
            return Lexeme.expression(text);
        }
    }
}
