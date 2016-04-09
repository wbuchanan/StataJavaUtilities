package org.paces.Stata.DataTypes;

import com.stata.sfi.*;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class StTypes {

	/**
	 * The Stata version calling this class
	 */
	private static final Integer version = Integer.valueOf(Double.valueOf(SFIToolkit.getCallerVersion()).intValue());

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Byte asByte(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(Byte.valueOf(fromAPI.byteValue()));
	}

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Integer asInteger(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(Integer.valueOf(fromAPI.intValue()));
	}

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Short asShort(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(Short.valueOf(fromAPI.shortValue()));
	}

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Long asLong(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(Long.valueOf(fromAPI.longValue()));
	}

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Float asFloat(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(Float.valueOf(fromAPI.floatValue()));
	}

	/**
	 * Method to cast datum returned by the Data.getNum method of the Stata
	 * Java API as a Byte value
	 * @param varid The variable index value
	 * @param obid The observation index value
	 * @return A Byte value from the specified variable for the observation obid
	 */
	public static Double asDouble(Integer varid, Number obid) {
		Double fromAPI;
		if (version == 13) fromAPI = Data.getNum(varid, obid.intValue());
		else fromAPI = Data.getNum(varid, obid.longValue());
		return(fromAPI);
	}

}
