package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    protected Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    protected Component findAllComponents(String text, String searchingRegexp) {
        Pattern pattern = Pattern.compile(searchingRegexp, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        Component compositeText = new Composite();
        while (matcher.find()) {
            String matchingText = matcher.group();
            Component component = successor.parse(matchingText);
            compositeText.add(component);
        }

        return compositeText;
    }
}
