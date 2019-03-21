package com.epam.infohandling.parser.impl;

import com.epam.infohandling.composite.Component;
import com.epam.infohandling.composite.impl.Composite;
import com.epam.infohandling.parser.Parser;

public class TextParser extends AbstractParser {

    @Override
    public Component parse(String text) {
        String[] paragraphs = text.split("\n");

        Composite compositeText = new Composite();
        Parser successor = getSuccessor();
        for (String paragraph : paragraphs) {
            Component paragraphComponent = successor.parse(paragraph);
            compositeText.add(paragraphComponent);
        }

        return compositeText;
    }
}