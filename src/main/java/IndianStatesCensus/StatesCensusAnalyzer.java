package IndianStatesCensus;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

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
	
	public static int getCensusDataCount(String filePath) throws CustomException
	{
		try {
			Reader reader=Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder<StatesCensusAnalyzer> csvBuilder = CSVBuilder.createCSVBuilder();
			Iterator<StatesCensusAnalyzer> csvIterator=csvBuilder.getCSVIterator(reader, StatesCensusAnalyzer.class);
			return CSVFileOperations.getCount(csvIterator);
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not Found!");
		}
	}
}
