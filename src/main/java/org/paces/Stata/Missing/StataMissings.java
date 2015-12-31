package org.paces.Stata.Missing;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by billy on 12/27/15.
 */
public class StataMissings {

	/**
	 * Method to test if a Stata byte type value (a Java byte) is an extended
	 * missing value or not.
	 * @param byteValue An Integer value to test
	 * @return A boolean indicating if the value is an extended missing value
	 * or not.
	 */
	public static Boolean isExtendedMissing(Byte byteValue) {

		// If the value is between the .a and .z values return true
		// If not return false
		return byteValue >= 102 && byteValue <= 127;

	} // End of method declaration

	/***
	 * Method returning a map object containing Stata missing values and
	 * their string masks (e.g., .a - .z)
	 * @return A map object containing mapped values of Stata byte types
	 */
	public static NavigableMap<Byte, String> byteMissing() {
		NavigableMap<Byte, String> mask = new TreeMap<>();
		mask.put((byte) 101, ".");
		mask.put((byte) 102, ".a");
		mask.put((byte) 103, ".b");
		mask.put((byte) 104, ".c");
		mask.put((byte) 105, ".d");
		mask.put((byte) 106, ".e");
		mask.put((byte) 107, ".f");
		mask.put((byte) 108, ".g");
		mask.put((byte) 109, ".h");
		mask.put((byte) 110, ".i");
		mask.put((byte) 111, ".j");
		mask.put((byte) 112, ".k");
		mask.put((byte) 113, ".l");
		mask.put((byte) 114, ".m");
		mask.put((byte) 115, ".n");
		mask.put((byte) 116, ".o");
		mask.put((byte) 117, ".p");
		mask.put((byte) 118, ".q");
		mask.put((byte) 119, ".r");
		mask.put((byte) 120, ".s");
		mask.put((byte) 121, ".t");
		mask.put((byte) 122, ".u");
		mask.put((byte) 123, ".v");
		mask.put((byte) 124, ".w");
		mask.put((byte) 125, ".x");
		mask.put((byte) 126, ".y");
		mask.put((byte) 127, ".z");
		return mask;
	} // End of method declaration

	/**
	 * Method to test if a Stata int type value (a Java short) is an extended
	 * missing value or not.
	 * @param shortValue A Short value to test
	 * @return A boolean indicating if the value is an extended missing value
	 * or not.
	 */
	public static Boolean isExtendedMissing(Short shortValue) {

		// If the value is between the .a and .z values return true
		// If not return false
		return shortValue >= 32742 && shortValue <= 32767;

	} // End of method declaration

	/***
	 * Method returning a map object containing Stata missing values and
	 * their string masks (e.g., .a - .z)
	 * @return A map object containing mapped values of Stata int types (e.g
	 * ., Java short types)
	 */
	public static NavigableMap<Short, String> integerMissing() {
		NavigableMap<Short, String> mask = new TreeMap<>();
		mask.put((short) 32741, ".");
		mask.put((short) 32742, ".a");
		mask.put((short) 32743, ".b");
		mask.put((short) 32744, ".c");
		mask.put((short) 32745, ".d");
		mask.put((short) 32746, ".e");
		mask.put((short) 32747, ".f");
		mask.put((short) 32748, ".g");
		mask.put((short) 32749, ".h");
		mask.put((short) 32750, ".i");
		mask.put((short) 32751, ".j");
		mask.put((short) 32752, ".k");
		mask.put((short) 32753, ".l");
		mask.put((short) 32754, ".m");
		mask.put((short) 32755, ".n");
		mask.put((short) 32756, ".o");
		mask.put((short) 32757, ".p");
		mask.put((short) 32758, ".q");
		mask.put((short) 32759, ".r");
		mask.put((short) 32760, ".s");
		mask.put((short) 32761, ".t");
		mask.put((short) 32762, ".u");
		mask.put((short) 32763, ".v");
		mask.put((short) 32764, ".w");
		mask.put((short) 32765, ".x");
		mask.put((short) 32766, ".y");
		mask.put((short) 32767, ".z");
		return mask;
	} // End of method declaration


	/**
	 * Method to test if a Stata long type value (a Java int) is an extended
	 * missing value or not.
	 * @param longValue An Integer value to test
	 * @return A boolean indicating if the value is an extended missing value
	 * or not.
	 */
	public static Boolean isExtendedMissing(Integer longValue) {

		// If the value is between the .a and .z values return true
		// If not return false
		return longValue >= 2147483621 && longValue <= 2147483647;

	} // End of method declaration

	/***
	 * Method returning a map object containing Stata missing values and
	 * their string masks (e.g., .a - .z)
	 * @return A map object containing mapped values of Stata long types (e.g
	 * ., Java int types)
	 */
	public static NavigableMap<Integer, String> longMissing() {
		NavigableMap<Integer, String> mask = new TreeMap<>();
		mask.put((int) 2147483621, ".");
		mask.put((int) 2147483622, ".a");
		mask.put((int) 2147483623, ".b");
		mask.put((int) 2147483624, ".c");
		mask.put((int) 2147483625, ".d");
		mask.put((int) 2147483626, ".e");
		mask.put((int) 2147483627, ".f");
		mask.put((int) 2147483628, ".g");
		mask.put((int) 2147483629, ".h");
		mask.put((int) 2147483630, ".i");
		mask.put((int) 2147483631, ".j");
		mask.put((int) 2147483632, ".k");
		mask.put((int) 2147483633, ".l");
		mask.put((int) 2147483634, ".m");
		mask.put((int) 2147483635, ".n");
		mask.put((int) 2147483636, ".o");
		mask.put((int) 2147483637, ".p");
		mask.put((int) 2147483638, ".q");
		mask.put((int) 2147483639, ".r");
		mask.put((int) 2147483640, ".s");
		mask.put((int) 2147483641, ".t");
		mask.put((int) 2147483642, ".u");
		mask.put((int) 2147483643, ".v");
		mask.put((int) 2147483644, ".w");
		mask.put((int) 2147483645, ".x");
		mask.put((int) 2147483646, ".y");
		mask.put((int) 2147483647, ".z");
		return mask;
	} // End of method declaration


} // End of Class declaration
