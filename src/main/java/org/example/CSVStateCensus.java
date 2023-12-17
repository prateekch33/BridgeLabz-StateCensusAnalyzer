package org.example;

import java.io.*;
import java.util.Iterator;

public class CSVStateCensus implements Iterable<String[]> {
    private final String filePath;

    public CSVStateCensus(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Iterator<String[]> iterator() {
        try {
            return new CSVIterator();
        } catch (StateCensusException e) {
            throw new RuntimeException(e);
        }
    }

    private class CSVIterator implements Iterator<String[]> {
        private BufferedReader reader;
        private String currentLine;

        public CSVIterator() throws StateCensusException {
            try {
                File file = new File(filePath);
                if (!file.exists()) {
                    throw new StateCensusException("File not found: " + filePath);
                }
                if (!filePath.toLowerCase().endsWith(".csv")) {
                    throw new StateCensusException("Incorrect file type. Expected CSV file.");
                }

                reader = new BufferedReader(new FileReader(file));
                    char expectedDelimiter=',';
                    String firstLine = reader.readLine();
                    String expectedHeader = "SrNo,StateName,TIN,StateCode";
                    String actualHeader = reader.readLine();
                    if (actualHeader == null || !actualHeader.equals(expectedHeader)) {
                        throw new StateCensusException("Invalid header. Expected: " + expectedHeader);
                    }
                    if (firstLine != null && !firstLine.contains(String.valueOf(expectedDelimiter))) {
                        throw new StateCensusException("Invalid delimiter. Expected: " + expectedDelimiter);
                    }

            } catch (StateCensusException e) {
                throw new StateCensusException(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean hasNext() {
            try {
                return (currentLine = reader.readLine()) != null;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public String[] next() {
            return currentLine.split(",");
        }
    }
}
