package org.paces.Stata.MetaData;

import org.paces.Stata.Variables.*;

import java.util.List;
import java.util.Map;

/**
 * Class used for Stata's Java API to access the metadata for Stata
 * variables.  This class is initialized by the Meta class object which also
 * builds/contains data related to the observation metadata.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class Variables {

	/**
	 * Class containing the variable index
	 */
	protected VariableIndex varindex;

	/**
	 * Class containing the variable index
	 */
	protected Nvars nvars;

	/**
	 * Class containing variable names
	 */
	protected VarNames varnames;

	/**
	 * Class containing variable to variable label Map
	 */
	protected VarLabels varlabels;

	/**
	 * Class containing value label names
	 */
	protected ValLabNames valueLabelNames;

	/**
	 * Class containing variable to variable label map
	 */
	protected ValLabels valueLabels;

	/**
	 * Class containing string variable indicators
	 */
	protected VarTypes varTypes;

	/**
	 * Initializes an instance of a VarNames class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setVarNames(VariableIndex varindex) {
		this.varnames = new VarNames(this.varindex);
	}

	/***
	 * Initialize an instance of an Nvars class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setNvars(VariableIndex varindex) {
		this.nvars = new Nvars(this.varindex);
	}

	/***
	 * Initialize an instance of a VarLabels class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setVarLabels(VariableIndex varindex) {
		this.varlabels = new VarLabels(this.varindex);
	}

	/***
	 * Initialize an instance of a ValLabNames class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setValLabNames(VariableIndex varindex) {
		this.valueLabelNames = new ValLabNames(this.varindex);
	}

	/***
	 * Initialize an instance of a ValLabels class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setValLabels(VariableIndex varindex) {
		this.valueLabels = new ValLabels(this.varindex);
	}

	/***
	 * Initialize an instance of a VarTypes class object
	 * @param varindex A VariableIndex object used to identify the variables
	 *                    over which the method will iterate over.
	 */
	public void setVarTypes(VariableIndex varindex) {
		this.varTypes = new VarTypes(this.varindex);
	}

	/***
	 * Initializes an instance of a VariableIndex object used by other
	 * methods to construct POJO representations of the variables' metadata.
	 */
	public void setVariableIndex() {
		this.varindex = new VariableIndex();
	}

	/***
	 * Class constructor method
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

	/***
	 * Method used to retrieve a List of Integer values containing the
	 * variable indices used to iterate over when constructing POJO
	 * representations of the Stata dataset.
	 * @return A List of Integer values representing the variable indices for
	 * the Stata Dataset.
	 */
	public List<Integer> getVariableIndex() {
		return this.varindex.getValues();
	}

	/***
	 * A method to retrieve a single variable index value
	 * @param indx The integer value of the element from the variable index
	 *                list to retrieve
	 * @return The variable index used to retrieve the data from Stata
	 */
	public int getVariableIndex(Integer indx) {
		return this.varindex.getValue(indx);
	}

	/***
	 * Method used to retrieve the number of variables represented on the JVM
	 * from the Stata dataset
	 * @return An int value of the number of variables represented in this
	 * object
	 */
	public int getNvars() {
		return this.nvars.getValues();
	}

	/***
	 * Method used to retrieve the list of variable names represented in this
	 * POJO
	 * @return A List of String values containing the Stata variable names
	 */
	public List<String> getVariableNames() {
		return this.varnames.getValues();
	}

	/***
	 * Method used to retrieve a single variable name given the variable
	 * index value
	 * @param varidx The integer value for the position of the List object
	 *                  containing the variable name
	 * @return A string containing the Stata variable name
	 */
	public String getVariableName(int varidx) {
		return this.varnames.getValue(varidx);
	}

	/***
	 * Method to retrieve the variable name/variable label key/value pairs
	 * @return A Map object with variable name key and variable label values
	 */
	public Map<String, String> getVariableLabels() {
		return this.varlabels.getValues();
	}

	/***
	 * Method used to retrieve the variable label for a single variable
	 * @param varnm The variable name for which the associated variable label
	 *                 should be returned.
	 * @return The variable label for the given variable name
	 */
	public String getVariableLabel(String varnm) {
		return this.varlabels.getValue(varnm);
	}

	/***
	 * The value label names associated with Stata variables
	 * @return A Map of variable name (key) / value label (value) pairs
	 */
	public Map<String, String> getValueLabelNames() {
		return this.valueLabelNames.getValues();
	}

	/***
	 * Method used to retrieve the variable label name associated with a
	 * given variable
	 * @param varnm the variable name for which the value label name should
	 *                 be retrieved
	 * @return A string containing the value label name
	 */
	public String getVarLabelName(String varnm) {
		return this.varlabels.getValue(varnm);
	}

	/***
	 * An object containing the value labels names as keys and the associated
	 * int/string key/value pairs for the value to label mappings
	 * @return An object with value label names (key) and value labels
	 * (value) pairs
	 */
	public Map<String, Map<Integer, String>> getValueLabels() {
		return this.valueLabels.getValues();
	}

	/***
	 * Method to retrieve a Map object indicating whether or not variables
	 * are of type string
	 * @return A key/value pair with variable name keys and boolean values
	 */
	public Map<String, Boolean> getVariableTypes() {
		return this.varTypes.getValues();
	}

	/***
	 * Method to retrieve whether a variable is a string type or not
	 * @param varnm The variable name to check
	 * @return A boolean indicating if the variable is a string or strL.
	 */
	public Boolean getVarType(String varnm) {
		return this.varTypes.getValue(varnm);
	}

} // End Class definition
