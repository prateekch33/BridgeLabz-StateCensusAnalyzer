package org.example;

import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyzer {
    private List<String[]> stateData;

    public StateCensusAnalyzer(CSVStateCensus csvStateCensus) {
        this.stateData = new ArrayList<>();
        loadStateData(csvStateCensus);
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

    public int getNumberOfRecords() throws StateCensusException {
        return getStateData().size();
    }
}
