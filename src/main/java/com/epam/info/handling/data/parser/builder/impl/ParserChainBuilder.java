package com.epam.info.handling.data.parser.builder.impl;

import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.ChainBuilder;
import com.epam.info.handling.data.parser.impl.LexemeParser;
import com.epam.info.handling.data.parser.impl.ParagraphParser;
import com.epam.info.handling.data.parser.impl.SentenceParser;
import com.epam.info.handling.data.parser.impl.TextParser;

public class ParserChainBuilder implements ChainBuilder<Parser> {

    @Override
    public Parser build() {
        LexemeParser lexemeParser = new LexemeParser();

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        return textParser;
    }
}
