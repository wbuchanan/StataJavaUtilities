package org.paces.Stata.Variables;

import com.stata.sfi.Data;
import com.stata.sfi.Macro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * Class containing string variable indicators
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class VarTypes {

	/***
	 * A name property for the object
	 */
	private final String name = "String Variable Indicator";

	/***
	 * Member variable containing indicators for whether or not the variable
	 * is of type String
	 */
	public Map<String, Boolean> varTypes;

	/**
	 * Member used to store Stata variable type integer values.
	 * These values can only be collected by running the following commands
	 * prior to the call to javacall:
	 * {@literal
	 *
	 * qui: ds
	 *
	 * foreach v in `r(varlist)' {
	 *
	 *     loc `v' `: type `v''
	 *
	 * }
	 *
	 * }
	 *
	 * Without the variable types being mapped to macros named by the
	 * variable name the types will be inaccessible.
	 *
	 */
	public List<Integer> stVarTypes = new ArrayList<>();

	public List<String> stJavaTypes = new ArrayList<>();

	/***
	 * Class constructor
	 * @param varIndex A variable index object used to iterate over when
	 *                    checking the type of a given variable
	 */
	public VarTypes(org.paces.Stata.Variables.VariableIndex varIndex) {

		// Sets the type index with booleans representing string types
		setVariableTypeIndex(varIndex.getValues());

		// Set the member containing the Stata variable types
		setStataVariableTypes(varIndex);

		// Sets the member containing the Java types
		setJavaVariableTypes(varIndex);

	} // End of Class constructor

	/**
	 * Method to create a list of integer values representing Stata data
	 * types based on the .dta file specification
	 * @param vdx An object of class VariableIndex
	 */
	public void setStataVariableTypes(VariableIndex vdx) {

		// Get the variable names to look up the local macro values
		VarNames stvnm = new VarNames(vdx);

		// Loops over the indices and adds all of the values to the list object
		stVarTypes.addAll(vdx.getValues().stream().map(i ->
				StataTypes.getType(
						Macro.getLocalSafe(stvnm.getValue(i))
				)).collect(Collectors.toList()));

	} // End of Method declaration

	/**
	 * Method to create a list of integer values representing Stata data
	 * types based on the .dta file specification
	 * @param vdx An object of class VariableIndex
	 */
	public void setJavaVariableTypes(VariableIndex vdx) {

		// Get the variable names to look up the local macro values
		VarNames stvnm = new VarNames(vdx);

		// Loops over the indices and adds all of the values to the list object
		stJavaTypes.addAll(vdx.getValues().stream().map(i ->
				StataTypes.getClassType(
						Macro.getLocalSafe(stvnm.getValue(i))
				)).collect(Collectors.toList()));

	} // End of Method declaration

	/***
	 * Sets an object containing booleans indicating whether the variable
	 * is/isn't a string.  Requires the variable index.
	 * @param vdx A list of integers containing the variable indices for
	 *               which the types are requested
	 */
	public void setVariableTypeIndex(List<Integer> vdx) {

		// Temporary Map variable
		Map<String, Boolean> tmpMap = new HashMap<String, Boolean>();

		// Loop over the variable index
		for (Integer varidx : vdx) {

			// Add elements to the map object
			tmpMap.put(Data.getVarName(varidx), Data.isVarTypeStr(varidx));

		} // End Loop

		// Set the variable type index
		this.varTypes = tmpMap;

	} // End setter method for variable type index

	/***
	 * @return A list of Boolean objects indicating if variable is a string
	 */
	public Map<String, Boolean> getValues() {
		return this.varTypes;
	}

	/***
	 * @param varnm valid variable index value
	 * @return Name of variable at index varidx
	 */
	public Boolean getValue(String varnm) {
		return this.varTypes.get(varnm);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method used to access the Stata data type list member of this class
	 * @return A list of integers representing the data type mappings from
	 * the .dta file specification
	 */
	public List<Integer> getStataTypes() {
		return this.stVarTypes;
	}

	/**
	 * Method used to access the Stata data type of a single variable
	 * @param index The variable index to look up
	 * @return An integer value representing the data type of the variable
	 * indexed by the parameter index based on the .dta file specification.
	 */
	public Integer getStataType(Integer index) {
		return this.stVarTypes.get(index);
	}

	public List<String> getJavaTypes() {
		return this.stJavaTypes;
	}

	public String getJavaType(Integer index) {
		return this.stJavaTypes.get(index);
	}

} // End of Inner class object definition