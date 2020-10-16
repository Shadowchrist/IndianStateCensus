/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package IndianStatesCensus;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.StreamSupport;
import com.opencsv.*;
import com.opencsv.bean.*;

public class CSVFileOperations {
	public static boolean checkHeaderArray(String[] mapping) throws CustomException {
		String path = "./src/main/java/resources/IndianStateCensusData.csv";
		try {
			Reader reader=Files.newBufferedReader(Paths.get(path));
			CSVParser parser=new CSVParserBuilder().build();
			CSVReader csvReader= new CSVReaderBuilder(reader).withCSVParser(parser).build();
			String[] header=csvReader.readNext();
			if(header==mapping)
				return true;
			else
			{
				throw new CustomException(CustomException.ExceptionType.INCORRECT_HEADER,"Header array is incorrect!");	
			}
		}
		catch(IOException e)
		{
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,e.getMessage());
		}
	}

	private static <E> int  getCount(Iterator<E> iterator)
	{
		Iterable<E> csvIterable=()-> iterator;
		return (int)(StreamSupport.stream(csvIterable.spliterator(), false)).count();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <E> Iterator<E> getCSVIterator(Reader reader, Class csvClass) throws CustomException
	{
		try
		{
			CsvToBeanBuilder<E> csvToBeanBuilder= new CsvToBeanBuilder<>(reader);
			CsvToBean<E> csvToBean=csvToBeanBuilder.withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
			return csvToBean.iterator();
		}catch(IllegalStateException e)
		{
			throw new CustomException(CustomException.ExceptionType.PARSING_ERROR,e.getMessage());
		}
	}

	public static int getCensusDataCount(String filePath) throws CustomException
	{
		try {
			Reader reader=Files.newBufferedReader(Paths.get(filePath));
			Iterator<StatesCensusAnalyzer> csvIterator=getCSVIterator(reader, StatesCensusAnalyzer.class);
			return getCount(csvIterator);
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,e.getMessage());
		}
	}
	
	public static boolean checkDelimiter(char delimiter) throws CustomException
	{
		if(delimiter==',')
			return true;
		else
			throw new CustomException(CustomException.ExceptionType.INCORRECT_DELIMITER,"Delimiter entered is not correct!");
	}

}

/*public int getStateCodeDateCount(String filePath) throws CustomException
{
	try {
		FileReader reader=new FileReader(filePath);
		List<CSVStates> stateCodeList=getCSVList(reader, CSVStates.class);
		return stateCodeList.size();
	} catch (IOException e) {
		throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,e.getMessage());
	}
}*/
