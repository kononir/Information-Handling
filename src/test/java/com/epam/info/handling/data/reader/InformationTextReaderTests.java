package com.epam.info.handling.data.reader;

import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;
import com.epam.info.handling.data.reader.impl.InformationTextReader;
import org.junit.Assert;
import org.junit.Test;

public class InformationTextReaderTests {
    private static final String PATH_TO_FILE_WITH_ONE_PARAGRAPH = "src/test/resources/one_paragraph.txt";
    private static final String PATH_TO_FILE_WITH_TWO_PARAGRAPHS = "src/test/resources/two_paragraphs.txt";
    private static final String INVALID_PATH = "invalid path";

    private static final String TEXT_WITH_ONE_PARAGRAPH = "\tOne paragraph.";
    private static final String TEXT_WITH_TWO_PARAGRAPHS = "\tFirst paragraph.\n\tSecond paragraph.";

    @Test
    public void testReadShouldReturnTextWithOneParagraphWhenGivenValidPathToTextWithOneParagraph()
            throws ReadingException, InvalidPathException {
        TextReader reader = new InformationTextReader();

        String actual = reader.read(PATH_TO_FILE_WITH_ONE_PARAGRAPH);

        Assert.assertEquals(TEXT_WITH_ONE_PARAGRAPH, actual);
    }

    @Test
    public void testReadShouldReturnTextWithTwoParagraphsWhenGivenValidPathToTextWithTwoParagraphs()
            throws ReadingException, InvalidPathException {
        TextReader reader = new InformationTextReader();

        String actual = reader.read(PATH_TO_FILE_WITH_TWO_PARAGRAPHS);

        Assert.assertEquals(TEXT_WITH_TWO_PARAGRAPHS, actual);
    }

    @Test(expected = InvalidPathException.class)
    public void testReadShouldThrowInvalidPathExceptionWhenGivenInvalidPath()
            throws ReadingException, InvalidPathException {
        TextReader reader = new InformationTextReader();

        reader.read(INVALID_PATH);

        Assert.fail();
    }
}
