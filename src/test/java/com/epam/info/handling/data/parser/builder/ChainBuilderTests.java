package com.epam.info.handling.data.parser.builder;

import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.impl.ChainBuilder;
import com.epam.info.handling.data.parser.impl.TextParser;
import org.junit.Assert;
import org.junit.Test;

public class ChainBuilderTests {

    @Test
    public void testBuildShouldReturnNewTextParser() {
        Builder<Parser> builder = new ChainBuilder();

        Parser textParser = builder.build();

        Assert.assertEquals(TextParser.class, textParser.getClass());
    }
}
