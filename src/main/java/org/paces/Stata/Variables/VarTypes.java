package org.paces.Stata.Variables;

import com.stata.sfi.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * Class constructor
	 * @param varIndex A variable index object used to iterate over when
	 *                    checking the type of a given variable
	 */
	public VarTypes(org.paces.Stata.Variables.VariableIndex varIndex) {

		// Sets the type index with booleans representing string types
		setVariableTypeIndex(varIndex.getValues());

	} // End of Class constructor

	/***
	 * Member variable containing indicators for whether or not the variable
	 * is of type String
	 */
	public Map<String, Boolean> varTypes;

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

} // End of Inner class object definition