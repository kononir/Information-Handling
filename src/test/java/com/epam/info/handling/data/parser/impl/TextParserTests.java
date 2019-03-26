package com.epam.info.handling.data.parser.impl;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class TextParserTests {
    private static final String TEXT_WITH_ONE_PARAGRAPH = "\tFirst paragraph.";
    private static final String TEXT_WITH_TWO_PARAGRAPHS = "\tFirst paragraph.\n\tSecond paragraph.";
    private static final String FIRST_PARAGRAPH = "\tFirst paragraph.";
    private static final String SECOND_PARAGRAPH = "\tSecond paragraph.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testParserShouldReturnTextCompositeWithOneParagraphCompositeWhenTextHasOnlyOneParagraph() {
        Parser paragraphParser = mock(ParagraphParser.class);
        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(new Composite());

        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        Component textComposite = textParser.parse(TEXT_WITH_ONE_PARAGRAPH);

        Assert.assertEquals(Composite.class, textComposite.getClass());

        List<Component> paragraphComposites = textComposite.getChildren();
        Assert.assertEquals(ONE_ELEMENT, paragraphComposites.size());

        verify(paragraphParser, atLeastOnce()).parse(FIRST_PARAGRAPH);

        Component firstParagraphComposite = paragraphComposites.get(FIRST);
        Assert.assertEquals(Composite.class, firstParagraphComposite.getClass());
    }

    @Test
    public void testParserShouldReturnTextCompositeWithTwoParagraphCompositesWhenTextHasTwoParagraph() {
        Parser paragraphParser = mock(ParagraphParser.class);
        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(new Composite());
        when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(new Composite());

        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        Component textComposite = textParser.parse(TEXT_WITH_TWO_PARAGRAPHS);

        Assert.assertEquals(Composite.class, textComposite.getClass());

        List<Component> paragraphComposites = textComposite.getChildren();
        Assert.assertEquals(TWO_ELEMENTS, paragraphComposites.size());

        verify(paragraphParser, atLeastOnce()).parse(FIRST_PARAGRAPH);
        Component firstParagraphComposite = paragraphComposites.get(FIRST);
        Assert.assertEquals(Composite.class, firstParagraphComposite.getClass());

        verify(paragraphParser, atLeastOnce()).parse(SECOND_PARAGRAPH);
        Component secondParagraphComposite = paragraphComposites.get(SECOND);
        Assert.assertEquals(Composite.class, secondParagraphComposite.getClass());
    }
}
