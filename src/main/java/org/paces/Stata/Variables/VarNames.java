package org.paces.Stata.Variables;
/**
 * Created by billy on 12/10/15.
 */

import com.stata.sfi.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Class containing variable names list
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class VarNames {

	/***
	 * A name property for the class
	 */
	private final String name = "Variable Names";

	/***
	 * Member variable containing Stata variable names
	 */
	private List<String> varnames;

	/***
	 * Class constructor method
	 * @param varIndex A variable index object
	 */
	public VarNames(VariableIndex varIndex) {
		setVariableNames(varIndex.getValues());
	}

	/***
	 * Sets an object containing variable names from Stata data set.
	 * Requires the variable index.
	 * @param vdx The Variable index over which the method will iterate.
	 */
	public void setVariableNames(List<Integer> vdx) {

		List<String> tmp = new ArrayList<>();

		// Iterate over the variable indices
		// Add the variable name to the list object
		tmp.addAll(vdx.stream().map(Data::getVarName).
				collect(Collectors.toList()));

		// Set the variable names member variable
		this.varnames = tmp;

	} // End setter method for variable names

	/***
	 * @return A list of String objects containing variable names
	 */
	public List<String> getValues() {
		return this.varnames;
	}

	/***
	 * @param varidx valid variable index value
	 * @return Name of variable at index varidx
	 */
	public String getValue(int varidx) {
		return this.varnames.get(varidx);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

} // End of Inner class object definition
