package com.epam.info.handling.data.reader.impl;

import com.epam.info.handling.data.reader.TextFileReader;
import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;

import java.io.*;

public class TextFileReaderImpl implements TextFileReader {

    @Override
    public String read(String path) throws InvalidPathException, ReadingException {
        StringBuilder textBuilder = new StringBuilder();

        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String firstLine = bufferedReader.readLine();
            if (firstLine != null) {
                textBuilder.append(firstLine);

                String nextLine = bufferedReader.readLine();
                while (nextLine != null) {
                    textBuilder.append('\n');
                    textBuilder.append(nextLine);

                    nextLine = bufferedReader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new InvalidPathException("Path to text file is invalid", e);
        } catch (IOException e) {
            throw new ReadingException("Reading problems", e);
        }

        return textBuilder.toString();
    }
}
