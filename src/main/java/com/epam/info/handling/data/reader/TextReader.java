package com.epam.info.handling.data.reader;

import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;

public interface TextReader {
    String read(String path) throws InvalidPathException, ReadingException;
}
