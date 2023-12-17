package org.example;

import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyzer {
    private List<String[]> stateData;
    private List<String> stateCodeData;

    public StateCensusAnalyzer(CSVStateCensus csvStateCensus) {
        this.stateData = new ArrayList<>();
        this.stateCodeData = new ArrayList<>();
        loadStateData(csvStateCensus);
        loadStateCodeData(csvStateCensus);
    }

    private void loadStateData(CSVStateCensus csvStateCensus) {
        for (String[] row : csvStateCensus) {
            stateData.add(row);
        }
        System.out.println("State Census Data loaded successfully.");
    }

    public List<String[]> getStateData() {
        return stateData;
    }

    private void loadStateCodeData(CSVStateCensus csvStateCensus) {
        for (String[] row : csvStateCensus) {
            // Process each row as needed
            String stateCode=row[0];
            stateCodeData.add(stateCode);
        }
        System.out.println("State Code Data loaded successfully.");
    }

    public List<String> getStateCodeData() {
        return stateCodeData;
    }

    public int getNumberOfRecords() throws StateCensusException {
        return getStateData().size();
    }
}
