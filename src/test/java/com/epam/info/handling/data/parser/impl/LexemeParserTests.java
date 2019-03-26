package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.data.composite.impl.lexeme.LexemeType;
import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.impl.LexemeParser;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTests {
    private static final String WORD = "Word";
    private static final String EXPRESSION = "12_13_14+-";

    @Test
    public void testParseShouldReturnWordLexemeWhenGivenTextWithWord() {
        Parser parser = new LexemeParser();

        Component wordComponent = parser.parse(WORD);

        Assert.assertEquals(Lexeme.class, wordComponent.getClass());

        Lexeme wordLexeme = (Lexeme) wordComponent;

        LexemeType lexemeType = wordLexeme.getType();
        Assert.assertEquals(LexemeType.WORD, lexemeType);

        String word = wordLexeme.getValue();
        Assert.assertEquals(WORD, word);
    }

    @Test
    public void testParseShouldReturnExpressionLexemeWhenGivenTextWithExpression() {
        Parser parser = new LexemeParser();

        Component expressionComponent = parser.parse(EXPRESSION);

        Assert.assertEquals(Lexeme.class, expressionComponent.getClass());

        Lexeme expressionLexeme = (Lexeme) expressionComponent;

        LexemeType lexemeType = expressionLexeme.getType();
        Assert.assertEquals(LexemeType.EXPRESSION, lexemeType);

        String expression = expressionLexeme.getValue();
        Assert.assertEquals(EXPRESSION, expression);
    }
}
