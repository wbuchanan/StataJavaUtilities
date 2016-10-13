package org.paces.Stata.Utilities;

import java.time.format.DateTimeFormatter;

/**
 * Static methods used to translate date values into standard formatted
 * date/datetime strings based on Stata conventions
 * Also need to implement small parser to handle the translation from Stata
 * datetime formats to the Java equivalents where possible.
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class StataDateDisplayFormats {

	/**
	 * Method for formatting clock time data
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter tc() {
		return DateTimeFormatter.ofPattern("ddMMMyyyy hh':'mm':'ss");
	}

	/**
	 * No equivalent in Java will return unadjusted time
	 * Need to implement constraint to make sure there are no :60 second values
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter tC() {
		return tc();
	}

	/**
	 * Standard date format
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter td() {
		return DateTimeFormatter.ofPattern("ddMMMyyyy");
	}

	/**
	 * Standard Weekly date format
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter tw() {
		return DateTimeFormatter.ofPattern("yyyy'w'ww");
	}

	/**
	 * Standard Monthly date format
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter tm() {
		return DateTimeFormatter.ofPattern("yyyy'm'LL");
	}

	/**
	 * Standard quarterly date format
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter tq() {
		return DateTimeFormatter.ofPattern("yyyyQQ");
	}

	/**
	 * Standard semi-annual date format
	 * Need to work on implementing this correctly since there is no half
	 * year format in Java
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter th() {
		return DateTimeFormatter.ofPattern("yyyy Q");
	}

	/**
	 * Standard yearly date format
	 * @return DateTimeFormatter class object for formatting a date value as
	 * a string
	 */
	public static DateTimeFormatter ty() {
		return DateTimeFormatter.ofPattern("yyyy");
	}






}


