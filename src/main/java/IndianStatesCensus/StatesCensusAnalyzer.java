package IndianStatesCensus;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import csvutility.*;
import com.opencsv.bean.*;

public class StatesCensusAnalyzer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@CsvBindByName(column="State Name",required=true)
	public String stateName;
	
	@CsvBindByName(column="Population",required=true)
	public long censusInfo;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public long getCensusInfo() {
		return censusInfo;
	}
	public void setCensusInfo(long censusInfo) {
		this.censusInfo = censusInfo;
	}
	
	public static List<StatesCensusAnalyzer> getCensusDataCount(String filePath) throws CustomException
	{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder<StatesCensusAnalyzer> csvBuilder = CSVBuilder.createCSVBuilder();
			List<StatesCensusAnalyzer> statesData = csvBuilder.getCSVList(reader, StatesCensusAnalyzer.class);
			return statesData;
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not Found!");
		}
	}
}
