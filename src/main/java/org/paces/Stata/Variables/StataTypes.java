package org.paces.Stata.Variables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Billy Buchanan
 * @version %G%
 */
public class StataTypes implements StataTypeInterface {

	/**
	 * Member used to map string values returned by the `: type [varname]'
	 * extended macro function to integer values used in the .dta
	 * specification to represent the data types.
	 */
	private static Map<String, Integer> typeMap = new HashMap<>();

	/**
	 * Member used to store the class types of the data so the values can be
	 * recast using reflection methods
	 */
	private static Map<String, String> typeClassMap = new HashMap<>();

	/**
	 * Class constructor for the StataTypes class.  The class calls the
	 * setMap() method to build the typeMap object and nothing else.
	 */
	StataTypes() {
		setMaps();
	}

	/**
	 * Method to translate a value from `: type [varname]' into an integer
	 * value corresponding to the data type based on the .dta file
	 * specification.
	 * @param type A string returned from the `: type ' extended macro
	 *                function (e.g., byte, int, long, float, double, str#,
	 *                strL)
	 * @return An integer corresponding to the variable type mapping listed
	 * in
	 * <a href="http://www.stata.com/help.cgi?dta#variabletypes">the .dta file specification</a>.
	 */
	public static Integer getType(String type) {
		return typeMap.get(type);
	}

	/**
	 * Like the getType method of this class, this method is used to look up
	 * variable type definitions for a valued retrieved from `: type [varnm]'
	 * .  The difference between the methods is that this method returns the
	 * class name string of the Java type that would represent the data
	 * correctly.
	 * @param type A string returned from the `: type ' extended macro
	 *                function (e.g., byte, int, long, float, double, str#,
	 *                strL)
	 * @return A fully specified Java class name (e.g., java.lang.String)
	 * that can be used to dynamically case the data using reflections.
	 */
	public static String getClassType(String type) {
		return typeClassMap.get(type);
	}

	/**
	 * Method used to construct the Map object used to look up values and
	 * return the appropriate type integer
	 */
	private static void setMaps() {
		typeMap.put("", 0);
		typeClassMap.put("", "java.lang.String");
		for(int i = 1; i <= 2045; i ++) {
			typeMap.put("str" + String.valueOf(i), i);
			typeClassMap.put("str" + String.valueOf(i), "java.lang.String");
		}
		typeMap.put("strL", 32768);
		typeClassMap.put("strL", "java.lang.String");
		typeMap.put("double", 65526);
		typeClassMap.put("double", "java.lang.Double");
		typeMap.put("float", 65527);
		typeClassMap.put("float", "java.lang.Float");
		typeMap.put("long", 65528);
		typeClassMap.put("long", "java.lang.Integer");
		typeMap.put("int", 65529);
		typeClassMap.put("int", "java.lang.Short");
		typeMap.put("byte", 65530);
		typeClassMap.put("byte", "java.lang.Byte");
	}




}
