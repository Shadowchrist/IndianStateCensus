package IndianStatesCensus;

import java.io.*;
import com.opencsv.bean.*;

public class StatesCensusAnalyzer implements Serializable {
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
}
