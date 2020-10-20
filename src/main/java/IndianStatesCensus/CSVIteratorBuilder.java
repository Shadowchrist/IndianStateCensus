package IndianStatesCensus;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVIteratorBuilder<E> implements ICSVBuilder<E> {

	@Override
	public Iterator<E> getCSVIterator(Reader reader, Class<E> csvClass) throws CustomException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			CsvToBean<E> csvToBean = csvToBeanBuilder.withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
			return csvToBean.iterator();
		} catch (IllegalStateException e) {
			throw new CustomException(CustomException.ExceptionType.PARSING_ERROR, "Unable to parse!");
		}
	}

}
