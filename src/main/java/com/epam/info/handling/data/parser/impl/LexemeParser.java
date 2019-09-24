package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String WORD_MATCHING_REGEXP = "\\w+";
    private static final String PUNCTUATION_MARK_MATCHING_REGEXP = "-|,|;|:|\\.{3}|\\.|!|\\?|\\(|\\)";

    @Override
    public Component parse(String text) {
        /* Unicode for Cyrillic symbols */
        Pattern pattern = Pattern.compile(WORD_MATCHING_REGEXP, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return Lexeme.word(text);
        } else if (text.matches(PUNCTUATION_MARK_MATCHING_REGEXP)) {
            return Lexeme.punctuationMark(text);
        } else {
            return Lexeme.expression(text);
        }
    }
}
