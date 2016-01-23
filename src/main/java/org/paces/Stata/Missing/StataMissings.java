package org.paces.Stata.Missing;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author Billy Buchanan
 * @version 0.0.0
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
	 * Method that returns the string mask for missing values of type byte
	 * @param value A Byte value for which the mask should be returned
	 * @return A string containing the extended missing value mask
	 */
	public String getMask(Byte value) {
		return byteMissing().get(value);
	}

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
	 * Method that returns the string mask for missing values of type short.
	 * <em>The short type in Java is equivalent to the int type in Stata.</em>
	 * @param value A Short (Stata int type) value for which the mask should be
	 *                 returned
	 * @return A string containing the extended missing value mask
	 */
	public String getMask(Short value) {
		return integerMissing().get(value);
	}

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

	/**
	 * Method that returns the string mask for missing values of type int.
	 * <em>The int type in Java is equivalent to the long type in Stata </em>
	 * @param value An Integer value for which the mask should be returned
	 * @return A string containing the extended missing value mask
	 */
	public String getMask(Integer value) {
		return longMissing().get(value);
	}


	/**
	 * Method to test if a Stata long type value (a Java int) is an extended
	 * missing value or not.
	 * @param fltValue A Float value to test
	 * @return A boolean indicating if the value is an extended missing value
	 * or not.
	 */
	public static Boolean isExtendedMissing(Float fltValue) {

		// If the value is between the .a and .z values return true
		// If not return false
		return fltValue >= 1.7014118E38 && fltValue <= 1.7122118E38;

	} // End of method declaration

	/***
	 * Method returning a map object containing Stata missing values and
	 * their string masks (e.g., .a - .z)
	 * @return A map object containing mapped values of Stata long types (e.g
	 * ., Java int types)
	 */
	public static NavigableMap<Float, String> floatMissing() {
		NavigableMap<Float, String> mask = new TreeMap<>();
		mask.put(1.7014118E38F, ".");
		mask.put(1.7018272E38F, ".a");
		mask.put(1.7022426E38F, ".b");
		mask.put(1.702658E38F, ".c");
		mask.put(1.7030734E38F, ".d");
		mask.put(1.7034888E38F, ".e");
		mask.put(1.7039041E38F, ".f");
		mask.put(1.7043195E38F, ".g");
		mask.put(1.704735E38F, ".h");
		mask.put(1.7051503E38F, ".i");
		mask.put(1.7055657E38F, ".j");
		mask.put(1.705981E38F, ".k");
		mask.put(1.7063964E38F, ".l");
		mask.put(1.7068118E38F, ".m");
		mask.put(1.7072272E38F, ".n");
		mask.put(1.7076426E38F, ".o");
		mask.put(1.708058E38F, ".p");
		mask.put(1.7084734E38F, ".q");
		mask.put(1.7088887E38F, ".r");
		mask.put(1.7093041E38F, ".s");
		mask.put(1.7097195E38F, ".t");
		mask.put(1.7101349E38F, ".u");
		mask.put(1.7105503E38F, ".v");
		mask.put(1.7109657E38F, ".w");
		mask.put(1.711381E38F, ".x");
		mask.put(1.7117964E38F, ".y");
		mask.put(1.7122118E38F, ".z");
		return mask;
	} // End of method declaration

	/**
	 * Method that returns the string mask for missing values of type float.
	 * Unlike the extended missing value types for whole numbers, floating
	 * point missing values are defined by a range of possible floating point
	 * values.  The range can be expressed roughly as n_[1] = [n_[1], n_[2]) or
	 * the minimum value for the extended missing value up to - but excluding
	 * - the next extended missing value.
	 * @param value A Float value for which the mask should be returned
	 * @return A string containing the extended missing value mask
	 */
	public String getMask(Float value) {
		return floatMissing().get(floatMissing().floorKey(value));
	}

	/**
	 * Method to test if a Stata long type value (a Java int) is an extended
	 * missing value or not.
	 * @param dblValue An Integer value to test
	 * @return A boolean indicating if the value is an extended missing value
	 * or not.
	 */
	public static Boolean isExtendedMissing(Double dblValue) {

		// If the value is between the .a and .z values return true
		// If not return false
		return dblValue >= 8.98846567431158E307 && dblValue <= 9.045521364627034E307;

	} // End of method declaration

	/***
	 * Method returning a map object containing Stata missing values and
	 * their string masks (e.g., .a - .z)
	 * @return A map object containing mapped values of Stata long types (e.g
	 * ., Java int types)
	 */
	public static NavigableMap<Double, String> doubleMissing() {
		NavigableMap<Double, String> mask = new TreeMap<>();
		mask.put(8.98846567431158E307D, ".");
		mask.put(8.990660123939097E307D, ".a");
		mask.put(8.992854573566614E307D, ".b");
		mask.put(8.995049023194132E307D, ".c");
		mask.put(8.99724347282165E307D, ".d");
		mask.put(8.999437922449167E307D, ".e");
		mask.put(9.001632372076684E307D, ".f");
		mask.put(9.003826821704202E307D, ".g");
		mask.put(9.00602127133172E307D, ".h");
		mask.put(9.008215720959237E307D, ".i");
		mask.put(9.010410170586754E307D, ".j");
		mask.put(9.012604620214272E307D, ".k");
		mask.put(9.01479906984179E307D, ".l");
		mask.put(9.016993519469307E307D, ".m");
		mask.put(9.019187969096824E307D, ".n");
		mask.put(9.021382418724342E307D, ".o");
		mask.put(9.02357686835186E307D, ".p");
		mask.put(9.025771317979377E307D, ".q");
		mask.put(9.027965767606894E307D, ".r");
		mask.put(9.030160217234412E307D, ".s");
		mask.put(9.03235466686193E307D, ".t");
		mask.put(9.034549116489447E307D, ".u");
		mask.put(9.036743566116964E307D, ".v");
		mask.put(9.038938015744481E307D, ".w");
		mask.put(9.041132465371999E307D, ".x");
		mask.put(9.043326914999516E307D, ".y");
		mask.put(9.045521364627034E307D, ".z");
		return mask;
	} // End of method declaration

	/**
	 * Method that returns the string mask for missing values of type double.
	 * Unlike the extended missing value types for whole numbers, floating
	 * point missing values are defined by a range of possible floating point
	 * values.  The range can be expressed roughly as n_[1] = [n_[1], n_[2]) or
	 * the minimum value for the extended missing value up to - but excluding
	 * - the next extended missing value.
	 * @param value A Double value for which the mask should be returned
	 * @return A string containing the extended missing value mask
	 */
	public String getMask(Double value) {
		return doubleMissing().get(doubleMissing().floorKey(value));
	}

} // End of Class declaration
