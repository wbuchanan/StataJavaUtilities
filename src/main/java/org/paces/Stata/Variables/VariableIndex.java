package org.paces.Stata.Variables;
import com.stata.sfi.Data;

import java.util.ArrayList;
import java.util.List;

/***
 * Class containing the variable indices.  This is used by all of the other
 * classes in the Variables package to extract and store data about the
 * variables in the active Stata session.
 * @author Billy Buchanan
 * @version %G%
 *
 */
public class VariableIndex {

	/***
	 * A name property for the class
	 */
	private final String name = "variable index";

	/***
	 * Member variable containing variable indices
	 */
	protected List<Integer> varindex;

	/***
	 * Class constructor method
	 */
	public VariableIndex() {
		setVariableIndex();
	}

	/***
	 * Populates the variable index member variable with the indices used to
	 * identify variables in the Stata dataset in memory.
	 */
	private void setVariableIndex() {

		// Initialize an empty array list of Integer objects
		List<Integer> vars = new ArrayList<>();

		// Get the number of parsed variables
		int parsed = Data.getParsedVarCount();

		// Get the total number of variables in the dataset
		int allvars = Data.getVarCount();

		// If there are variables parsed from the variable list
		if (parsed != allvars) {

			// Loop over the variables
			for (int i = 1; i <= parsed; i++) {

				// Get the index for the individual variables passed as a
				// varlist
				vars.add(Data.mapParsedVarIndex(i));

			} // End Loop over varlist variables

			// Set the variable index member variable's values
			this.varindex = vars;

		} else {

			// Loop over the total indices of variables
			for (int i = 0; i < allvars; i++) {

				// Add the index value to the list object
				vars.add(i + 1);

			} // End Loop over values

			// Set the variable index member variable's values
			this.varindex = vars;

		} // End IF/ELSE Block for variable list handling

	} // End setter method for varindex variable

	/***
	 * Accessor method for variable index variable
	 * @return A list of Integer objects containing variable indices
	 */
	public List<Integer> getValues() {
		return this.varindex;
	}

	/***
	 * Method to retrieve the index of a single variable
	 * @param indx The Java index value to search
	 * @return Returns the index value in the position specified by the
	 * parameter indx.
	 */
	public Integer getValue(Integer indx) {
		return this.varindex.get(indx);
	}

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

	/***
	 * Accessor method for variable index variable
	 * @return A list of Integer objects containing variable indices
	 */
	public List<Integer> getVarIndexValues() {
		return this.varindex;
	}

	/***
	 * Method to retrieve the index of a single variable
	 * @param indx The Java index value to search
	 * @return Returns the index value in the position specified by the
	 * parameter indx.
	 */
	public Integer getVarIndexValue(Integer indx) {
		return this.varindex.get(indx);
	}

} // End of Inner class definition

