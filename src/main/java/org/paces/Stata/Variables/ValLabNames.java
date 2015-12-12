package org.paces.Stata.Variables;
/**
 * Created by billy on 12/10/15.
 */

import com.stata.sfi.Data;
import com.stata.sfi.ValueLabel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Class used to store value label names
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class ValLabNames {

	/***
	 * Member variable to store a name property
	 */
	private final String name = "Variable Label Names";

	/***
	 * Member variable containing Stata value label names associated with a
	 * given variable
	 */
	public Map<String, String> valueLabelNames;

	/***
	 * Class constructor method
	 * @param varIndex A variable index class object
	 */
	public ValLabNames(VariableIndex varIndex) {
		setValueLabelNames(varIndex.getValues());
	}

	/***
	 * Sets an object containing name of value label associated with the
	 * index value. Requires the variable index.
	 * @param vdx A list of integers for variable index values to iterate over
	 */
	public void setValueLabelNames(List<Integer> vdx) {

		// Initialize object used to store the variabel name to value label
		// name mapping object
		Map<String, String> nValueLabelNames = new HashMap<String, String>();

		// Iterate over the variable indices
		for (Integer vindx : vdx) {

			// Get the Variable name
			String tmpVarName = Data.getVarName(vindx);

			// Assign the variable label name to a temporary variable
			String tmpLabel = ValueLabel.getVarValueLabel(vindx);

			// If the method returned null add an empty string to the list
			// object.  Otherwise, add the value returned from the method
			if (tmpLabel != null) {
				if (!tmpLabel.isEmpty()) nValueLabelNames.put(tmpVarName, tmpLabel);
			} // End IF Block for value label names

		} // End Loop

		// Set the variable names member variable
		this.valueLabelNames = nValueLabelNames;

	} // End setter method for variable labels

	/***
	 * @return A list of String objects containing value label names.
	 */
	public Map<String, String> getValues() {
		return this.valueLabelNames;
	}

	/***
	 * @param varnm valid variable name
	 * @return Name of value label associated with a given variable index
	 */
	public String getValue(String varnm) {
		return this.valueLabelNames.get(varnm);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

} // End of Inner class object definition