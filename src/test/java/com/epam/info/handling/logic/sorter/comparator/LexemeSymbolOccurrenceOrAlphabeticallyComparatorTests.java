package com.epam.info.handling.logic.sorter.comparator;

import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.logic.sorter.comporator.LexemeSymbolOccurrenceOrAlphabeticallyComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class LexemeSymbolOccurrenceOrAlphabeticallyComparatorTests {
    private static final int ZERO = 0;

    private static final String DESIRED_SYMBOL = "s";
    private static final String MORE_OCCURRENCES = "bbbbbbsssssss";
    private static final String LESS_OCCURRENCES = "s";

    private static final String EQUAL_OCCURRENCE_FIRST_AT_ALPHABET = "bsss";
    private static final String EQUAL_OCCURRENCE_SECOND_AT_ALPHABET = "csss";

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenFirstLexemeHasMoreOccurrencesOfDesiredSymbol() {
        Lexeme firstLexeme = Lexeme.word(MORE_OCCURRENCES);
        Lexeme secondLexeme = Lexeme.word(LESS_OCCURRENCES);

        Comparator<Lexeme> comparator = new LexemeSymbolOccurrenceOrAlphabeticallyComparator(DESIRED_SYMBOL);

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstLexemeHasLessOccurrencesOfDesiredSymbol() {
        Lexeme firstLexeme = Lexeme.word(LESS_OCCURRENCES);
        Lexeme secondLexeme = Lexeme.word(MORE_OCCURRENCES);

        Comparator<Lexeme> comparator = new LexemeSymbolOccurrenceOrAlphabeticallyComparator(DESIRED_SYMBOL);

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenLexemesHaveEqualOccurrencesOfDesiredSymbol() {
        Lexeme firstLexeme = Lexeme.word(LESS_OCCURRENCES);
        Lexeme secondLexeme = Lexeme.word(LESS_OCCURRENCES);

        Comparator<Lexeme> comparator = new LexemeSymbolOccurrenceOrAlphabeticallyComparator(DESIRED_SYMBOL);

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertEquals(ZERO, actual);
    }

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenLexemesHaveEqualOccurrencesOfDesiredSymbolAndFirstLexemeStayBeforeAtAlphabet() {
        Lexeme firstLexeme = Lexeme.word(EQUAL_OCCURRENCE_FIRST_AT_ALPHABET);
        Lexeme secondLexeme = Lexeme.word(EQUAL_OCCURRENCE_SECOND_AT_ALPHABET);

        Comparator<Lexeme> comparator = new LexemeSymbolOccurrenceOrAlphabeticallyComparator(DESIRED_SYMBOL);

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual > ZERO);
    }
}
