package com.epam.info.handling;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.parser.Parser;
import com.epam.info.handling.data.parser.builder.ChainBuilder;
import com.epam.info.handling.data.reader.TextReader;
import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;
import com.epam.info.handling.data.recovery.RecoveryExecutor;
import com.epam.info.handling.data.recovery.exception.TextRecoveryInvalidLexemeValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {
    private TextReader reader;
    private ChainBuilder<Parser> parserBuilder;
    private RecoveryExecutor recoveryExecutor;

    private static final Logger LOGGER = LogManager.getRootLogger();

    public Director(TextReader reader, ChainBuilder<Parser> parserBuilder, RecoveryExecutor recoveryExecutor) {
        this.reader = reader;
        this.parserBuilder = parserBuilder;
        this.recoveryExecutor = recoveryExecutor;
    }

    public String handleInformation(String path) {
        String recoveringText = null;

        try {
            String text = reader.read(path);

            Parser textParser = parserBuilder.build();
            Component component = textParser.parse(text);

            recoveringText = recoveryExecutor.executeRecovery(component);
        } catch (InvalidPathException | ReadingException | TextRecoveryInvalidLexemeValueException e) {
            LOGGER.fatal(e);
        }

        return recoveringText;
    }
}
