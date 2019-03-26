package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.data.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class SentenceParserTests {
    private static final String SENTENCE_WITH_WORD_AND_DOT = "Word.";
    private static final String SENTENCE_WITH_EXPRESSION_AND_DOT = "12_13_14+-.";
    private static final String SENTENCE_WITH_WORD_EXPRESSION_AND_DOT = "Word 12_13_14+-.";
    private static final String WORD = "Word";
    private static final String EXPRESSION = "12_13_14+-";
    private static final String DOT = ".";

    private static final int TWO_ELEMENTS = 2;
    private static final int THREE_ELEMENTS = 3;

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    @Test
    public void testParseShouldReturnSentenceCompositeWithTwoWordLexemesWhenSentenceHasWordAndDot() {
        Parser lexemeParser = mock(LexemeParser.class);
        when(lexemeParser.parse(WORD)).thenReturn(Lexeme.word(WORD));
        when(lexemeParser.parse(DOT)).thenReturn(Lexeme.word(DOT));

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_WORD_AND_DOT);

        Assert.assertEquals(Composite.class, sentenceComposite.getClass());

        List<Component> wordLexemes = sentenceComposite.getChildren();
        Assert.assertEquals(TWO_ELEMENTS, wordLexemes.size());

        verify(lexemeParser, atLeastOnce()).parse(WORD);
        Component firstWordLexeme = wordLexemes.get(FIRST);
        Assert.assertEquals(Lexeme.class, firstWordLexeme.getClass());

        verify(lexemeParser, atLeastOnce()).parse(DOT);
        Component secondWordLexeme = wordLexemes.get(SECOND);
        Assert.assertEquals(Lexeme.class, secondWordLexeme.getClass());
    }

    @Test
    public void testParseShouldReturnSentenceCompositeWithOneExpressionAndOneWordLexemesWhenSentenceHasExpressionAndDot() {
        Parser lexemeParser = mock(LexemeParser.class);
        when(lexemeParser.parse(EXPRESSION)).thenReturn(Lexeme.expression(EXPRESSION));
        when(lexemeParser.parse(DOT)).thenReturn(Lexeme.word(DOT));

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_EXPRESSION_AND_DOT);

        Assert.assertEquals(Composite.class, sentenceComposite.getClass());

        List<Component> lexemes = sentenceComposite.getChildren();
        Assert.assertEquals(TWO_ELEMENTS, lexemes.size());

        verify(lexemeParser, atLeastOnce()).parse(EXPRESSION);
        Component firstLexeme = lexemes.get(FIRST);
        Assert.assertEquals(Lexeme.class, firstLexeme.getClass());

        verify(lexemeParser, atLeastOnce()).parse(DOT);
        Component secondLexeme = lexemes.get(SECOND);
        Assert.assertEquals(Lexeme.class, secondLexeme.getClass());
    }

    @Test
    public void testParseShouldReturnSentenceCompositeWithOneExpressionAndTwoWordLexemesWhenSentenceHasWordExpressionAndDot() {
        Parser lexemeParser = mock(LexemeParser.class);
        when(lexemeParser.parse(WORD)).thenReturn(Lexeme.word(WORD));
        when(lexemeParser.parse(EXPRESSION)).thenReturn(Lexeme.expression(EXPRESSION));
        when(lexemeParser.parse(DOT)).thenReturn(Lexeme.word(DOT));

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_WORD_EXPRESSION_AND_DOT);

        Assert.assertEquals(Composite.class, sentenceComposite.getClass());

        List<Component> lexemes = sentenceComposite.getChildren();
        Assert.assertEquals(THREE_ELEMENTS, lexemes.size());

        verify(lexemeParser, atLeastOnce()).parse(WORD);
        Component firstLexeme = lexemes.get(FIRST);
        Assert.assertEquals(Lexeme.class, firstLexeme.getClass());

        verify(lexemeParser, atLeastOnce()).parse(EXPRESSION);
        Component secondLexeme = lexemes.get(SECOND);
        Assert.assertEquals(Lexeme.class, secondLexeme.getClass());

        verify(lexemeParser, atLeastOnce()).parse(DOT);
        Component thirdLexeme = lexemes.get(THIRD);
        Assert.assertEquals(Lexeme.class, thirdLexeme.getClass());
    }
}
