package IndianStatesCensus;

public class CSVBuilder {
	public static <E> ICSVBuilder<E> createCSVBuilder() {
		return new CSVIteratorBuilder<E>();
	}
}
