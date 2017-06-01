package org.paces.Stata.Variables;

import java.util.Map;

/**
 * Defines a method to identify Stata data types given the typeMap object and the string containing the display format.
 * This will not correctly identify datetime types, but will correctly map all other types and will return the int
 * valued numeric code used in the .dta file specifications to identify the data type.
 * @author Billy Buchanan
 * @version %G%
 */
public interface StataTypeInterface {

	/**
	 * Method to look up the Stata data type given the type map and the display format
	 * @param typeMap A typemap created by the implementing class(es)
	 * @param type The string containing the display format
	 * @return Returns the integer valued Stata data type corresponding to the display format.
	 */
	default Integer getStataType(Map<String, Integer> typeMap, String type) {
		return typeMap.get(type);
	}

}
