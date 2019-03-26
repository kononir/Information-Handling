package com.epam.info.handling;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.Builder;
import com.epam.info.handling.data.reader.TextFileReader;
import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;
import com.epam.info.handling.logic.interpreter.ExpressionInterpreter;

public class Director {
    private TextFileReader reader;
    private Builder<Parser> parserBuilder;
    private ExpressionInterpreter<Integer> interpreter;

    public Director(TextFileReader reader, Builder<Parser> parserBuilder, ExpressionInterpreter<Integer> interpreter) {
        this.reader = reader;
        this.parserBuilder = parserBuilder;
        this.interpreter = interpreter;
    }

    public String handleInformation(String path) {
        String recoveringText = null;

        try {
            String text = reader.read(path);

            Parser textParser = parserBuilder.build();
            Component component = textParser.parse(text);
        } catch (InvalidPathException | ReadingException e) {
            e.printStackTrace();
        }

        return recoveringText;
    }
}
