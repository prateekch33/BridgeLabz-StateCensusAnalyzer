package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "StateCensus.csv";

        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFilePath);

        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer(csvStateCensus);

        List<String[]> loadedData = stateCensusAnalyser.getStateData();
        for (String[] row : loadedData) {
            System.out.println(String.join(", ", row));
        }
    }
}