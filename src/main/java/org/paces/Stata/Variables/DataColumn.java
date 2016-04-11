package org.paces.Stata.Variables;

import com.stata.sfi.Data;
import org.paces.Stata.DataTypes.StTypes;
import org.paces.Stata.MetaData.Meta;
import org.paces.Stata.MetaData.Variables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class to return all values of a single Stata variable.
 * This class requires the detection of the Stata variable types.
 * @author Billy Buchanan
 * @version 0.0.0
 * @see org.paces.Stata.Variables.VarTypes
 */
public class DataColumn {

	/***
	 * A Meta class object contains meta data for the dataset in memory
	 */
	private Meta metaob;

	private Variables stvars;

	/***
	 * A List of double values from a single variable
	 */
	protected List<?> vardata = new ArrayList<>();

	/**
	 * Member containing the variable name
	 */
	protected String varname;

	/**
	 * Member containing the variable label
	 */
	protected String varlabel;

	/**
	 * Member containing associated value labels
	 */
	protected Map<Integer, String> valuelabel = null;

	/**
	 * Member to store the variable type string
	 */
	//protected String dataclass;

	/**
	 * Member containing the Stata data type.
	 */
	protected Integer stDataType;

	public List<?> getData() {
		return this.vardata;
	}

	public String getVarName() {
		return this.varname;
	}

	public String getVarLabel() {
		return this.varlabel;
	}

	// public String getJavaType() {
	// 	return this.dataclass;
	// }
	// public Integer getStataType() {
	// 	return this.stDataType;
	// }

	public Map<Integer, String> getValueLabel() {
		return this.valuelabel;
	}
	/***
	 * Generic constructor for the class
	 * @param varidx The variable index from which to get records
	 */
	public DataColumn(Integer varidx) {

		// Populates the Meta class member variable
		this.metaob = new Meta();

		this.stvars = this.metaob.getStatavars();

		// Sets the values in the object based on a variable from the Stata
		// dataset
		setData(varidx) ;

	} // End Class constructor method

	/**
	 * Method used to set the data and remaining meta data members
	 * @param idx The integer valued variable index
	 */
	private void setData(Integer idx) {
		this.varname = this.stvars.getVariableName(idx);
		this.varlabel = this.stvars.getVariableLabel(this.varname);
		if (this.stvars.getValLabelsObject().getValue(this.varname) != null) {
			this.valuelabel = this.stvars.getValLabelsObject().getValue(this.varname);
		} else {
			this.valuelabel.put(0, "");
		}
		// this.stDataType = this.stvars.getStVarType(idx);
		// this.dataclass = this.stvars.getVarTypesObject().getJavaType(idx);
		this.vardata = makeList(this.stDataType, idx, this.metaob.getObs13());
	}

	/**
	 * Method to initialize the list object containing the individual datum
	 * @param type The integer valued Stata data type
	 * @param varidx The integer valued variable index
	 * @param obindex The observation index member of the Observations class
	 * @return A list object containing the data elements from a single variable
	 */
	private List<?> makeList(Integer type, Integer varidx, List<Integer>
		obindex) {
		if (type <= 32768) {
			List<String> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(Data.getStr(varidx, ob));
			return tmp;
		} else if (type == 65526) {
			List<Double> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(StTypes.asDouble(varidx, ob));
			return tmp;
		} else if (type == 65527) {
			List<Float> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(StTypes.asFloat(varidx, ob));
			return tmp;
		} else if (type == 65528) {
			List<Integer> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(StTypes.asInteger(varidx, ob));
			return tmp;
		} else if (type == 65529) {
			List<Short> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(StTypes.asShort(varidx, ob));
			return tmp;
		} else {
			List<Byte> tmp = new ArrayList<>();
			for(Integer ob : obindex) tmp.add(StTypes.asByte(varidx, ob));
			return tmp;
		}
	}

}
