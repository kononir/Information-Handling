package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;

public class ParagraphParser extends AbstractParser {
    private static final String SEARCHING_REGEXP = "[^\\t\\s.?!][^.?!]*(\\.{3}|\\.|\\?|!)";

    @Override
    public Component parse(String text) {
        return findAllComponents(text, SEARCHING_REGEXP);
    }
}
