package com.epam.info.handling.logic.sorter.impl;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.logic.sorter.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LexemeSorterBySymbolOccurrenceOrAlphabeticallyTests {
    private static final String DESIRED_SYMBOL = "s";
    private static final String MORE_OCCURRENCES = "bbbbbbsssssss";
    private static final String LESS_OCCURRENCES = "s";

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedInDescendingOrderLexemesWhenGivenNotSortedLexemesWithDifferentOccurrencesNumber() {
        List<Lexeme> unsorted = Arrays.asList(
                Lexeme.word(MORE_OCCURRENCES),
                Lexeme.word(LESS_OCCURRENCES)
        );

        Sorter<Lexeme> sorter = new LexemeSorterBySymbolOccurrenceOrAlphabetically(DESIRED_SYMBOL);

        List<Lexeme> sorted = sorter.sort(unsorted);

        Lexeme firstLexeme = sorted.get(FIRST);
        Assert.assertEquals(MORE_OCCURRENCES, firstLexeme.getValue());

        Lexeme secondLexeme = sorted.get(SECOND);
        Assert.assertEquals(LESS_OCCURRENCES, secondLexeme.getValue());
    }
}
