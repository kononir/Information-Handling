package com.epam.info.handling.data.recovery;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.composite.impl.lexeme.Lexeme;
import com.epam.info.handling.data.recovery.exception.TextRecoveryInvalidLexemeValueException;
import com.epam.info.handling.data.recovery.impl.TextRecoveryExecutor;
import org.junit.Assert;
import org.junit.Test;

public class TextRecoveryExecutorTests {
    private static final String FIRST_WORD_VALUE = "First";
    private static final String SECOND_WORD_VALUE = "One";
    private static final String THIRD_WORD_VALUE = "hyphen";
    private static final String HYPHEN_LEXEME_VALUE = "-";
    private static final String POINT_LEXEME_VALUE = ".";

    private static final String NULL_LEXEME_VALUE = null;

    private static final String ONE_PARAGRAPH_TEXT = "\tFirst.";
    private static final String TWO_PARAGRAPHS_TEXT = "\tFirst.\n\tOne - hyphen.";

    @Test
    public void testExecuteRecoveryShouldReturnOneParagraphTextWhenGivenTextCompositeWithOneChild()
            throws TextRecoveryInvalidLexemeValueException {
        Component firstWordLexeme = Lexeme.word(FIRST_WORD_VALUE);
        Component secondWordLexeme = Lexeme.word(POINT_LEXEME_VALUE);

        Component sentenceComposite = new Composite();
        sentenceComposite.add(firstWordLexeme);
        sentenceComposite.add(secondWordLexeme);

        Component paragraphComposite = new Composite();
        paragraphComposite.add(sentenceComposite);

        Component textComposite = new Composite();
        textComposite.add(paragraphComposite);

        RecoveryExecutor recoveryExecutor = new TextRecoveryExecutor();

        String actual = recoveryExecutor.executeRecovery(textComposite);

        Assert.assertEquals(ONE_PARAGRAPH_TEXT, actual);
    }

    @Test
    public void testExecuteRecoveryShouldReturnTwoParagraphsTextWhenGivenTextCompositeWithTwoChildren()
            throws TextRecoveryInvalidLexemeValueException {
        Component firstWordLexeme = Lexeme.word(FIRST_WORD_VALUE);
        Component secondWordLexeme = Lexeme.word(POINT_LEXEME_VALUE);

        Component firstSentenceComposite = new Composite();
        firstSentenceComposite.add(firstWordLexeme);
        firstSentenceComposite.add(secondWordLexeme);

        Component firstParagraphComposite = new Composite();
        firstParagraphComposite.add(firstSentenceComposite);

        Component thirdWordLexeme = Lexeme.word(SECOND_WORD_VALUE);
        Component fourthWordLexeme = Lexeme.word(HYPHEN_LEXEME_VALUE);
        Component fifthWordLexeme = Lexeme.word(THIRD_WORD_VALUE);
        Component sixthWordLexeme = Lexeme.word(POINT_LEXEME_VALUE);

        Component secondSentenceComposite = new Composite();
        secondSentenceComposite.add(thirdWordLexeme);
        secondSentenceComposite.add(fourthWordLexeme);
        secondSentenceComposite.add(fifthWordLexeme);
        secondSentenceComposite.add(sixthWordLexeme);

        Component secondParagraphComposite = new Composite();
        secondParagraphComposite.add(secondSentenceComposite);

        Component textComposite = new Composite();
        textComposite.add(firstParagraphComposite);
        textComposite.add(secondParagraphComposite);

        RecoveryExecutor recoveryExecutor = new TextRecoveryExecutor();

        String actual = recoveryExecutor.executeRecovery(textComposite);

        Assert.assertEquals(TWO_PARAGRAPHS_TEXT, actual);
    }

    @Test(expected = TextRecoveryInvalidLexemeValueException.class)
    public void testExecuteRecoveryShouldThrowTextRecoveryInvalidLexemeValueExceptionWhenGivenFirstLexemeWithNullValue()
            throws TextRecoveryInvalidLexemeValueException {
        Component firstWordLexeme = Lexeme.word(NULL_LEXEME_VALUE);
        Component secondWordLexeme = Lexeme.word(POINT_LEXEME_VALUE);

        Component sentenceComposite = new Composite();
        sentenceComposite.add(firstWordLexeme);
        sentenceComposite.add(secondWordLexeme);

        Component paragraphComposite = new Composite();
        paragraphComposite.add(sentenceComposite);

        Component textComposite = new Composite();
        textComposite.add(paragraphComposite);

        RecoveryExecutor recoveryExecutor = new TextRecoveryExecutor();

        recoveryExecutor.executeRecovery(textComposite);

        Assert.fail();
    }

    @Test(expected = TextRecoveryInvalidLexemeValueException.class)
    public void testExecuteRecoveryShouldThrowTextRecoveryInvalidLexemeValueExceptionWhenGivenSecondLexemeWithNullValue()
            throws TextRecoveryInvalidLexemeValueException {
        Component firstWordLexeme = Lexeme.word(FIRST_WORD_VALUE);
        Component secondWordLexeme = Lexeme.word(NULL_LEXEME_VALUE);

        Component sentenceComposite = new Composite();
        sentenceComposite.add(firstWordLexeme);
        sentenceComposite.add(secondWordLexeme);

        Component paragraphComposite = new Composite();
        paragraphComposite.add(sentenceComposite);

        Component textComposite = new Composite();
        textComposite.add(paragraphComposite);

        RecoveryExecutor recoveryExecutor = new TextRecoveryExecutor();

        recoveryExecutor.executeRecovery(textComposite);

        Assert.fail();
    }
}
