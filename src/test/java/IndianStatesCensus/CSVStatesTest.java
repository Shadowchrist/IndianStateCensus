package IndianStatesCensus;

import static org.junit.Assert.*;

import org.junit.Test;

public class CSVStatesTest {

	@Test
	public void ifNumberOfEntriesAreCorrect_HappyCase() throws CustomException {
		try {
			int result=CSVStates.getStateCodeCount("./src/main/resources/IndianStateCensusData.csv");
			assertEquals(36, result);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void ifFilePathIsWrong_SadCase() {
			try {
				String[] mapping = new String[] { "Sr No.", "State Name", "TIN", "Population", "State Code" };
				assertTrue(CSVFileOperations.checkHeaderArrayFilePathAndDelimiter(mapping,"./src/main/IndianStateCensusData.csv",','));
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
	
	@Test
	public void ifHeaderIsWrong_SadCase() {
		try {
			String[] mapping = new String[] { "Sr No.", "State name", "TIN", "Population", "State code" };	
			assertTrue(CSVFileOperations.checkHeaderArrayFilePathAndDelimiter(mapping,"./src/main/resources/IndianStateCensusData.csv",','));
		} catch (CustomException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void ifDelimiterIsWrong_SadCase() {
		try {
			String[] mapping = new String[] { "Sr No.", "State Name", "TIN", "Population", "State Code" };	
			assertTrue(CSVFileOperations.checkHeaderArrayFilePathAndDelimiter(mapping,"./src/main/resources/IndianStateCensusData.csv",';'));
		} catch (CustomException e) {
			
			System.out.println(e.getMessage());
		}
	}

}
