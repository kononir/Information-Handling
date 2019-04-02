package com.epam.info.handling.data.parser.builder;

import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.impl.ParserChainBuilder;
import com.epam.info.handling.data.parser.impl.TextParser;
import org.junit.Assert;
import org.junit.Test;

public class ParserChainBuilderTests {

    @Test
    public void testBuildShouldReturnNewTextParser() {
        ChainBuilder<Parser> builder = new ParserChainBuilder();

        Parser textParser = builder.build();

        Assert.assertEquals(TextParser.class, textParser.getClass());
    }
}
