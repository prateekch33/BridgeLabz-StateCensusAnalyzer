import org.example.CSVStateCensus;
import org.example.StateCensusAnalyzer;
import org.example.StateCensusException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StateCensusTest {

    @Test
    public void testNumberOfRecordsMatches() throws StateCensusException {
        String correctFilePath = "StateCensus.csv";
        CSVStateCensus csvStateCensus=new CSVStateCensus(correctFilePath);
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer(csvStateCensus);
        int expectedRecords = 37;

        int actualRecords = stateCensusAnalyzer.getNumberOfRecords();

        assertEquals(expectedRecords, actualRecords);
    }

    @Test
    public void testIncorrectFilePathReturnsException() {
        String correctFilePath = "StateCensus1.csv";
        CSVStateCensus csvStateCensus=new CSVStateCensus(correctFilePath);
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer(csvStateCensus);

        assertThrows(RuntimeException.class, stateCensusAnalyzer::getNumberOfRecords);
    }

    @Test
    public void testCorrectFilePathButIncorrectTypeReturnsException() {
        String correctFilePath = "StateCensus.txt";
        CSVStateCensus csvStateCensus=new CSVStateCensus(correctFilePath);
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer(csvStateCensus);

        assertThrows(RuntimeException.class, stateCensusAnalyzer::getNumberOfRecords);
    }

    @Test
    public void testCorrectFilePathButIncorrectDelimiterReturnsException() {
        String correctFilePath = "StateCensus2.csv";
        CSVStateCensus csvStateCensus=new CSVStateCensus(correctFilePath);
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer(csvStateCensus);

        assertThrows(RuntimeException.class, stateCensusAnalyzer::getNumberOfRecords);
    }

    @Test
    public void testCorrectFilePathButIncorrectHeaderReturnsException() {
        String correctFilePath = "StateCensus2.csv";
        CSVStateCensus csvStateCensus=new CSVStateCensus(correctFilePath);
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer(csvStateCensus);

        assertThrows(RuntimeException.class, stateCensusAnalyzer::getNumberOfRecords);
    }
}
