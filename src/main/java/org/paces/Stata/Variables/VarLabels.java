package org.paces.Stata.Variables;
/**
 * Created by billy on 12/10/15.
 */

import com.stata.sfi.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Class containing variable label map
 */
public class VarLabels {

	/***
	 * Name property for the class
	 */
	private final String name = "Variable Labels";

	/***
	 * Member variable containing Stata variable labels
	 */
	private Map<String, String> varlabels;

	/***
	 * Variable labels inner class object
	 * @param varIndex A variable index object
	 */
	public VarLabels(VariableIndex varIndex) {
		setVariableLabels(varIndex.getValues());
	}

	/***
	 * Sets an object containing variable labels from Stata data set.
	 * Requires the variable index.
	 */
	public void setVariableLabels(List<Integer> vdx) {

		Map<String, String> newVariableLabels = new HashMap<String, String>();

		// Iterate over the variable indices
		for (Integer varid : vdx) {

			// Create a Map object with the variable name as the key and the
			// variable label as the value for the Map object
			newVariableLabels.put(Data.getVarName(varid), Data.getVarLabel
					(varid));

		} // End Loop over variable index

		// Set the member variable varlabels to the value of newVariableLabels
		this.varlabels = newVariableLabels;

	} // End setter method for variable labels

	/***
	 * @return A list of String objects containing variable labels.
	 */
	public Map<String, String> getValues() {
		return this.varlabels;
	}

	/***
	 * @param varnm valid variable name
	 * @return Variable Label
	 */
	public String getValue(String varnm) {
		return this.varlabels.get(varnm);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

} // End of Inner class object definition