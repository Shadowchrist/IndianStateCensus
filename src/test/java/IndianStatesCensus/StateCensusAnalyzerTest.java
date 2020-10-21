package IndianStatesCensus;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;

import csvutility.CustomException;

public class StateCensusAnalyzerTest {

	@Test
	public void ifNumberOfEntriesAreCorrect_HappyCase() throws CustomException {
		try {
			int result=StatesCensusAnalyzer.getCensusDataCount("./src/main/resources/IndianStateCensusData.csv").size();
			assertEquals(36, result);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void ifFilePathIsWrong_SadCase() throws CustomException {
		String[] mapping = new String[] { "Sr No.", "State Name", "TIN", "Population", "State Code" };
		assertTrue(CSVFileOperations.checkHeaderArrayFilePathAndDelimiter(mapping,"./src/main/IndianStateCensusData.csv",','));
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
		
	@Test
	public void givenStateCensusDataOnSortingByStateNameShouldMatchSortedResult() throws IOException {
		CSVFileOperations<StatesCensusAnalyzer> censusAnalyser = new CSVFileOperations<StatesCensusAnalyzer>();
		try {
			String sortedData = censusAnalyser.sortStateDataByName();
			StatesCensusAnalyzer[] stateData = new Gson().fromJson(sortedData,StatesCensusAnalyzer[].class);
			assertEquals("Andaman and Nicobar Islands", stateData[0].stateName);
			assertEquals("Chandigarh", stateData[5].stateName);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenStateCensusDataOnSortingByStateCodeShouldMatchSortedResult() throws IOException {
		CSVFileOperations<StatesCensusAnalyzer> censusAnalyser = new CSVFileOperations<StatesCensusAnalyzer>();
		try {
			String sortedData = censusAnalyser.sortStateDataByCode();
			StatesCensusAnalyzer[] stateData = new Gson().fromJson(sortedData,StatesCensusAnalyzer[].class);
			assertEquals("Andaman and Nicobar Islands", stateData[0].stateName);
			assertEquals("Chhattisgarh", stateData[5].stateName);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
}	
