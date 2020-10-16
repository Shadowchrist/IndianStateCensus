package IndianStatesCensus;

import java.io.*;
import com.opencsv.bean.*;

public class CSVStates implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@CsvBindByName(column="State Name",required=true)
	public String stateName;
	@CsvBindByName(column="State Code",required=true)
	public int stateCode;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public long getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}	
}
