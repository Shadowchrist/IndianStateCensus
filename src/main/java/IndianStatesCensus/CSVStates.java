package IndianStatesCensus;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.*;

public class CSVStates implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@CsvBindByName(column="State Name",required=true)
	public String stateName;
	@CsvBindByName(column="State Code",required=true)
	public char stateCode;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public long getStateCode() {
		return stateCode;
	}
	public void setStateCode(char stateCode) {
		this.stateCode = stateCode;
	}
	
	public static int getStateCodeCount(String filePath) throws CustomException
	{
		try {
			Reader reader=Files.newBufferedReader(Paths.get(filePath));
			Iterator<CSVStates> csvIterator=CSVFileOperations.getCSVIterator(reader, CSVStates.class);
			return CSVFileOperations.getCount(csvIterator);
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,"File not found!");
		}
	}
}
