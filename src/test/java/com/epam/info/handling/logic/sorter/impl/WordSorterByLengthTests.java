package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.logic.sorter.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordSorterByLengthTests {
    private static final String LONGER_VALUE = "LongerLongerLonger";
    private static final String SHORTER_VALUE = "S";

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedWordsWhenFirstWordLonger() {
        List<Lexeme> unsorted = Arrays.asList(
                Lexeme.word(LONGER_VALUE),
                Lexeme.word(SHORTER_VALUE)
        );

        Sorter<Lexeme> sorter = new WordSorterByLength();

        List<Lexeme> sorted = sorter.sort(unsorted);

        Lexeme firstLexeme = sorted.get(FIRST);
        Assert.assertEquals(SHORTER_VALUE, firstLexeme.getValue());

        Lexeme secondLexeme = sorted.get(SECOND);
        Assert.assertEquals(LONGER_VALUE, secondLexeme.getValue());
    }
}
