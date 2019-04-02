package com.epam.info.handling.logic.sorter.comparator;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.logic.sorter.comporator.CompositeChildrenNumberComparator;
import com.epam.info.handling.logic.sorter.comporator.LexemeLengthComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class LexemeLengthComparatorTests {
    private static final int ZERO = 0;

    private static final String LONGER_VALUE = "LongerLongerLonger";
    private static final String SHORTER_VALUE = "S";

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenFirstLexemeLonger() {
        Lexeme firstLexeme = Lexeme.word(LONGER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Lexeme> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstLexemeShorter() {
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(LONGER_VALUE);

        Comparator<Lexeme> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenLexemesHaveEqualLength() {
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Lexeme> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertEquals(ZERO, actual);
    }
}
