package org.paces.Stata.Variables;

import com.stata.sfi.*;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class VarDisplay implements VarInterface {

	/**
	 * Private member that defines regular expression to match any of the
	 * basic Date/DateTime formats in Stata
	 */
	private static final Pattern datefmt = Pattern.compile("%t[cCdwmqhy]");

	/***
	 * A name property for the object
	 */
	private final String name = "String Variable Indicator";

	/***
	 * Member variable containing indicators for whether or not the variable
	 * is of type String
	 */
	private Map<String, String> varTypes = new HashMap<>();


	/**
	 * Class constructor for variable display formats
	 * @param varIndex The variable index object defining the variables to
	 *                    look up.
	 */
	public VarDisplay(VariableIndex varIndex) {
		
		// First line in class constructor
		for (Integer varidx : varIndex.getValues())
			this.varTypes.put(Data.getVarName(varidx), Data.getVarFormat(varidx));
		
	}

	/***
	 * @return A list of Boolean objects indicating if variable is a string
	 */
	public Map<String, String> getValues() {
		return this.varTypes;
	}

	/***
	 * Method to access the format type for a variable
	 * @param varnm The variable index whose format to look up
	 * @return Name of variable at index varidx
	 */
	public String getValue(String varnm) {
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
		return this.varTypes.keySet().iterator();

	} // End of getIterator method

	/**
	 * Method to check if a specific variable includes the letter t
	 * (indicating a date/datetime format)
	 * @param varnm The variable index value to look up
	 * @return A boolean indicating if the variable is a date time formatted
	 * variable
	 */
	public Boolean isDate(String varnm) {
		return datefmt.matcher(this.getValue(varnm)).find();
	}

	/**
	 * Returns a List of Booleans indicating whether or not the variable is a
	 * date/datetime type
	 * @return a List of booleans indicating whether the value is a date or
	 * datetime type
	 */
	public List<Boolean> areDate() {
		List<Boolean> b = new ArrayList<>();
		for(String i : this.varTypes.keySet()) b.add(isDate(i));
		return b;
	}



}
