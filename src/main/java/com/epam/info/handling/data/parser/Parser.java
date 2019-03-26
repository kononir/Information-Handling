package com.epam.info.handling.data.parser;

import com.epam.info.handling.data.composite.Component;

public interface Parser {
    Component parse(String text);
}
