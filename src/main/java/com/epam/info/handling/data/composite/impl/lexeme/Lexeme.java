package com.epam.info.handling.data.composite.impl.lexeme;

import com.epam.info.handling.data.composite.Component;

import java.util.Collections;
import java.util.List;

public class Lexeme implements Component {
    private String value;
    private LexemeType type;

    private Lexeme(String value, LexemeType type) {
        this.value = value;
        this.type = type;
    }

    // методы статической генерации
    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public LexemeType getType() {
        return type;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }
}
