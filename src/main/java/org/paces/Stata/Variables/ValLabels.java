package org.paces.Stata.Variables;

import com.stata.sfi.Data;
import com.stata.sfi.ValueLabel;

import java.util.*;

/***
 * Class used to store value labels from Stata data set
 * @author Billy Buchanan
 * @version %G%
 *
 */
public class ValLabels implements VarInterface {

	/***
	 * Name attribute for the class
	 */
	private final String name = "Value Labels";

	/***
	 * Member variable containing a list of Map objects with the values and
	 * associated labels contained in the Map object
	 */
	private Map<String, Map<Integer, String>> valueLabels;

	/***
	 * Class constructor method
	 * @param varIndex A list of integer values used to retrieve associated
	 *                    value labels
	 */
	public ValLabels(VariableIndex varIndex) {

		// Sets the valueLabels property of the class
		setValueLabels(varIndex.getValues());

	} // End of Class constructor

	/***
	 * Sets an object with the value labels defined for a given variable.
	 * Requires the variable index.
	 * @param vdx The Variable index over which the method will iterate.
	 */
	private void setValueLabels(List<Integer> vdx) {

		// New Value Label object uses variable name for key and contains the
		// map of integers/strings for the key and value pairs used for
		// value labels
		Map<String, Map<Integer, String>> valLabels = new HashMap<String,
				Map<Integer, String>>();

		// Loop over the variable indices
		for (Integer vindx : vdx) {

			// Create temp object to store the value label set
			Map<Integer, String> labels = new HashMap<>();

			// Get the Variable name
			String tmpVarName = Data.getVarName(vindx);

			// Assign the variable label name to a temporary variable
			String tmpLabel = ValueLabel.getVarValueLabel(vindx);

			// Test whether the object is null/empty
			if (!tmpLabel.isEmpty()) {

				// Add the value labels to the object
				labels.putAll(ValueLabel.getValueLabels(tmpLabel));

				// Add the value labels to the object
				valLabels.put(tmpVarName, labels);

			} // End IF Block for variables with associated value labels

		} // End Loop over value label name index

		// Set the value label index variable
		this.valueLabels = valLabels;

	} // End setter method for value label index

	/***
	 * @return A list of Map objects containing the value/label pairs for
	 * labeled variables or the keyword "skip" to indicate the variable does not
	 * have any value labels associated with it.
	 */
	public Map<String, Map<Integer, String>> getValues() {
		return this.valueLabels;
	}

	/***
	 * Method to retrieve a single value
	 * @param varname Variable name used to identify element to return
	 * @return A map object containing the key/value pairs showing how
	 * strings are encoded to the numeric values.
	 */
	public Map<Integer, String> getValue(String varname) {
		return this.valueLabels.get(varname);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method used to return the appropriate iterator needed to iterate over the
	 * values stored in the object.
	 *
	 * For this object the iterator values can be passed to the .getValue()
	 * method to access individual data elements.
	 *
	 * @return An Iterator object
	 */
	@Override
	public Iterator getIterator() {

		// Returns an iterator over the individual keys.
		return this.valueLabels.keySet().iterator();

	} // End of getIterator method

} // End of Inner class object definition