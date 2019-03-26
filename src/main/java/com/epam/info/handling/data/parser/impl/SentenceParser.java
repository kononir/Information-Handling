package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;

public class SentenceParser extends AbstractParser {
    private static final String SEARCHING_REGEXP = "[\\w&&[^\\d]]+|(\\d+(_\\d+)*[+\\-*/^]*)|\\.{3}|\\.|\\?|!|\\(|\\)|,|;|-|:";

    @Override
    public Component parse(String text) {
        return findAllComponents(text, SEARCHING_REGEXP);
    }
}
