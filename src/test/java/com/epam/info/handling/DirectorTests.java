package com.epam.info.handling;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.composite.impl.Composite;
import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.ChainBuilder;
import com.epam.info.handling.data.parser.builder.impl.ParserChainBuilder;
import com.epam.info.handling.data.parser.impl.TextParser;
import com.epam.info.handling.data.reader.TextReader;
import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;
import com.epam.info.handling.data.reader.impl.InformationTextReader;
import com.epam.info.handling.data.recovery.RecoveryExecutor;
import com.epam.info.handling.data.recovery.exception.TextRecoveryInvalidLexemeValueException;
import com.epam.info.handling.data.recovery.impl.TextRecoveryExecutor;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DirectorTests {
    private static final String VALID_PATH = "src/test/resources/one_paragraph.txt";
    private static final String TEXT = "\tOne paragraph.";

    @Test
    public void testHandleInformationShouldReturnSameTextWhenGivenText()
            throws ReadingException, InvalidPathException, TextRecoveryInvalidLexemeValueException{
        TextReader reader = mock(InformationTextReader.class);
        when(reader.read(VALID_PATH)).thenReturn(TEXT);

        Component textComposite = new Composite();

        Parser textParser = mock(TextParser.class);
        when(textParser.parse(TEXT)).thenReturn(textComposite);

        ChainBuilder<Parser> parserBuilder = mock(ParserChainBuilder.class);
        when(parserBuilder.build()).thenReturn(textParser);

        RecoveryExecutor recoveryExecutor = mock(TextRecoveryExecutor.class);
        when(recoveryExecutor.executeRecovery(textComposite)).thenReturn(TEXT);

        Director director = new Director(reader, parserBuilder, recoveryExecutor);

        String actual = director.handleInformation(VALID_PATH);

        Assert.assertEquals(TEXT, actual);

        verify(reader, atLeastOnce()).read(VALID_PATH);
        verify(parserBuilder, atLeastOnce()).build();
        verify(textParser, atLeastOnce()).parse(TEXT);
        verify(recoveryExecutor, atLeastOnce()).executeRecovery(textComposite);
    }
}
