package IndianStatesCensus;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCensusAnalyzerTest {

	@Test
	public void ifNumberOfEntriesAreCorrect_HappyCase() throws CustomException {
		int result=CSVFileOperations.getCensusDataCount("./src/main/resources/IndianStateCensusData.csv");
		assertEquals(36, result);
	}
	
}	
