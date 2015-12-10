package org.paces.Stata.MetaData;

import org.paces.Stata.Variables.*;

import java.util.List;
import java.util.Map;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 * <h2>Stata Variable MetaData Object</h2>
 * <p>Class used for Stata's Java API to access the metadata for Stata
 * variables.  This class is initialized by the Meta class object.</p>
 */
public class Variables {

	/***
	 * Class containing the variable index
	 */
	private VariableIndex varindex;

	/***
	 * Class containing the variable index
	 */
	private Nvars nvars;

	/***
	 * Class containing variable names
	 */
	private VarNames varnames;

	/***
	 * Class containing variable -> variable label Map
	 */
	private VarLabels varlabels;

	/***
	 * Class containing value label names
	 */
	private ValLabNames valueLabelNames;

	/***
	 * Class containing variable -> variable label map
	 */
	private ValLabels valueLabels;

	/***
	 * Class containing string variable indicators
	 */
	private VarTypes varTypes;

	public void setVarNames(VariableIndex varindex) {
		this.varnames = new VarNames(this.varindex);
	}

	public void setNvars(VariableIndex varindex) {
		this.nvars = new Nvars(this.varindex);
	}

	public void setVarLabels(VariableIndex varindex) {
		this.varlabels = new VarLabels(this.varindex);
	}

	public void setValLabNames(VariableIndex varindex) {
		this.valueLabelNames = new ValLabNames(this.varindex);
	}

	public void setValLabels(VariableIndex varindex) {
		this.valueLabels = new ValLabels(this.varindex);
	}

	public void setVarTypes(VariableIndex varindex) {
		this.varTypes = new VarTypes(this.varindex);
	}

	public void setVariableIndex() {
		this.varindex = new VariableIndex();
	}

	public List<Integer> getVariableIndex() {
		return this.varindex.getValues();
	}

	public int getVariableIndex(Integer indx) { return this.varindex.getValue(indx); }

	public int getNvars() {
		return this.nvars.getValues();
	}

	public List<String> getVariableNames() {
		return this.varnames.getValues();
	}

	public String getVariableName(int varidx) {
		return this.varnames.getValue(varidx);
	}

	public Map<String, String> getVariableLabels() {
		return this.varlabels.getValues();
	}

	public String getVariableLabel(String varnm) {
		return this.varlabels.getValue(varnm);
	}

	public Map<String, String> getValueLabelNames() {
		return this.valueLabelNames.getValues();
	}

	public String getVarLabelName(String varnm) {
		return this.varlabels.getValue(varnm);
	}

	public Map<String, Map<Integer, String>> getValueLabels() {
		return this.valueLabels.getValues();
	}

	public Map<String, Boolean> getVariableTypes() {
		return this.varTypes.getValues();
	}

	public Boolean getVarType(String varnm) {
		return this.varTypes.getValue(varnm);
	}

	/***
	 * Generic constructor when no varlist is passed
	 */
	Variables() {

		// Set the variable index member variable
		setVariableIndex();

		// Set the number of variables member variable
		setNvars(this.varindex);

		// Set the variable name member variable
		setVarNames(this.varindex);

		// Set the variable label member variable
		setVarLabels(this.varindex);

		// Set the value label name member variable
		setValLabNames(this.varindex);

		// Set the value label value/label pair member variable
		setValLabels(this.varindex);

		// Set the variable is string index member variable
		setVarTypes(this.varindex);

	} // End constructor method


} // End Class definition
