package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.impl.ParagraphParser;
import com.epam.info.handling.data.parser.impl.SentenceParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ParagraphParserTests {
    private static final String PARAGRAPH_WITH_ONE_SENTENCE = "\tFirst sentence.";
    private static final String PARAGRAPH_WITH_TWO_SENTENCES = "\tFirst sentence. Second sentence.";
    private static final String FIRST_SENTENCE = "First sentence.";
    private static final String SECOND_SENTENCE = "Second sentence.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testParseShouldReturnParagraphCompositeWithOneSentenceCompositeWhenParagraphHasOnlyOneSentence() {
        Parser sentenceParser = mock(SentenceParser.class);
        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(new Composite());

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_ONE_SENTENCE);

        Assert.assertEquals(Composite.class, paragraphComposite.getClass());

        List<Component> sentenceComposites = paragraphComposite.getChildren();
        Assert.assertEquals(ONE_ELEMENT, sentenceComposites.size());

        verify(sentenceParser, atLeastOnce()).parse(FIRST_SENTENCE);

        Component firstSentenceComposite = sentenceComposites.get(FIRST);
        Assert.assertEquals(Composite.class, firstSentenceComposite.getClass());
    }

    @Test
    public void testParserShouldReturnParagraphCompositeWithTwoSentenceCompositesWhenParagraphHasTwoSentences() {
        Parser sentenceParser = mock(ParagraphParser.class);
        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(new Composite());
        when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(new Composite());

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_TWO_SENTENCES);

        Assert.assertEquals(Composite.class, paragraphComposite.getClass());

        List<Component> sentenceComposites = paragraphComposite.getChildren();
        Assert.assertEquals(TWO_ELEMENTS, sentenceComposites.size());

        verify(sentenceParser, atLeastOnce()).parse(FIRST_SENTENCE);
        Component firstSentenceComposite = sentenceComposites.get(FIRST);
        Assert.assertEquals(Composite.class, firstSentenceComposite.getClass());

        verify(sentenceParser, atLeastOnce()).parse(SECOND_SENTENCE);
        Component secondSentenceComposite = sentenceComposites.get(SECOND);
        Assert.assertEquals(Composite.class, secondSentenceComposite.getClass());
    }
}
