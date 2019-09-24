package com.epam.info.handling.data.reader.impl;

import com.epam.info.handling.data.reader.TextReader;
import com.epam.info.handling.data.reader.exception.InvalidPathException;
import com.epam.info.handling.data.reader.exception.ReadingException;

import java.io.*;

public class InformationTextReader implements TextReader {

    @Override
    public String read(String path) throws InvalidPathException, ReadingException {
        StringBuilder textBuilder = new StringBuilder();

        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
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
