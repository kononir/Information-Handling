package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.parser.Parser;

public class TextParser extends AbstractParser {
    private static final String SPLITTER_REGEXP = "\n";

    @Override
    public Component parse(String text) {
        String[] strings = text.split(SPLITTER_REGEXP);

        Parser successor = getSuccessor();

        Component compositeText = new Composite();
        for (String s : strings) {
            Component component = successor.parse(s);
            compositeText.add(component);
        }

        return compositeText;
    }
}