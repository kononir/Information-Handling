package com.epam.info.handling;

import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.Builder;
import com.epam.info.handling.data.parser.builder.impl.ChainBuilder;
import com.epam.info.handling.data.parser.impl.TextParser;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectorTests {

    @Test
    public void testHandleInformationShouldReturnSameTextWhenGivenText() {
        Builder<Parser> parserBuilder = mock(ChainBuilder.class);
        Parser textParser = mock(TextParser.class);
        when(parserBuilder.build()).thenReturn(textParser);


    }
}
