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

    // methods of static generation
    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme punctuationMark(String value) {
        return new Lexeme(value, LexemeType.PUNCTUATION_MARK);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public boolean isWord() {
        return LexemeType.WORD.equals(type);
    }

    public boolean isPunctuationMark() {
        return LexemeType.PUNCTUATION_MARK.equals(type);
    }

    public boolean isExpression() {
        return LexemeType.EXPRESSION.equals(type);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }
}
