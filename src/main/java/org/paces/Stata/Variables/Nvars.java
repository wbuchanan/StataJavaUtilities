package org.paces.Stata.Variables;

import java.util.List;

/***
 * Class containing number of variables
 */
public class Nvars {

	/***
	 * Name property for the class
	 */
	private final String name = "number of variabels";

	/***
	 * Number of variables passed from javacall
	 */
	private int nvars;

	/***
	 * Class constructor method
	 * @param varIndex A VariableIndex class object
	 */
	public Nvars(VariableIndex varIndex) {

		// Pass the variable index to the setter method
		setNvars(varIndex.getValues());

	} // End constructor declaration

	/***
	 * Method to set the number of variables passed to javacall
	 * @param varidx A variable index
	 */
	public void setNvars(List<Integer> varidx) {

		// Set nvars based on the size of the List of integer objects
		this.nvars = varidx.size();

	} // End setter method for nvars

	/***
	 * Method to access the number of variables passed from javacall
	 * @return An integer value with the number of variables passed to javacall
	 */
	public int getValues() {

		// Returns the nvars member variable
		return this.nvars;

	} // End of getter method for nvars member variable

	/***
	 * Method to retrieve the name of the JSON object
	 * @return A string with the name of the JSON object
	 */
	public String getName() {
		return this.name;
	}

} // End of Inner class object definition
