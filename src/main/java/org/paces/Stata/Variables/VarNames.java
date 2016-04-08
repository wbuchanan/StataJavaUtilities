package org.paces.Stata.Variables;

import com.stata.sfi.*;
import java.util.*;
import java.util.stream.Collectors;

/***
 * Class containing variable names list
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class VarNames implements VarInterface {

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
	private void setVariableNames(List<Integer> vdx) {

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

	/**
	 * Method used to return the appropriate iterator needed to iterate over the
	 * values stored in the object.
	 *
	 * For this object the iterator values are the individual variable names
	 *
	 * @return An Iterator object
	 */
	@Override
	public Iterator getIterator() {

		// Returns an iterator over the individual keys.
		return this.varnames.iterator();

	} // End of getIterator method



} // End of Inner class object definition
