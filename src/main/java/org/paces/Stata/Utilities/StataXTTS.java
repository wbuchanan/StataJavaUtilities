package org.paces.Stata.Utilities;

import java.nio.file.attribute.FileTime;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Class and Methods to convert Java Date, Time, and Timestamp objects to Stata
 * representations. This class and the methods should be tested a bit more
 * before use in a production environment.
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class StataXTTS {

	/***
	 * System default zone ID
	 */
	private final ZoneId zid = ZoneId.systemDefault();

	/***
	 * Constant for the Stata Epoch date
	 */
	private final Instant STATAEPOCH =
			LocalDateTime.of(1960, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);

	/***
	 * Constant for the Java Epoch date
	 */
	private final Instant JAVAEPOCH =
			LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);

	public static void main(String[] args) {
		new StataXTTS();
	}

	/**
	 * Method to convert Java Dates to Stata Dates
	 * @param datetime A date object to convert to a Stata datetime value
	 * @return Double precision milliseconds elapsed since 01jan1960
	 */
	public Double toStata(Date datetime) {

		// Return the date value with the epoch date adjusted
		return (double) datetime.toLocalDate().minusYears(10).toEpochDay();

	} // End toStata method declaration for Date object classes

	/**
	 * Method to convert Java Times to Stata Datetimes
	 * @param datetime A time object returned from the JDBC query
	 * @return Double precision milliseconds elapsed since 01jan1960
	 */
	public Double toStata(Time datetime) {

		// Return the double value to convert to a Stata value
		return (double) datetime.toLocalTime().minus(10, YEARS).toNanoOfDay();

	} // End toStata method declaration for Time object classes

	/**
	 * Method to convert Java Timestamps to Stata Datetimes
	 * @param datetime  A timestamp object returned from the JDBC query
	 * @return A long integer containing the number of milliseconds past the
	 * Stata epoch (01jan1960) precision milliseconds elapsed since
	 * 01jan1960.  The value can be displayed correctly in Stata using the
	 * %tc format.
	 */
	public Double toStata(Timestamp datetime) {

		// Convert timestamp variable to an instant class object
		Long javadate = datetime.toInstant().toEpochMilli();

		// Return the object with the time offset adjustment
		return (double) javadate - STATAEPOCH.minusMillis(JAVAEPOCH
				.toEpochMilli()).toEpochMilli();

	} // End toStata method declaration for Timestamp object classes

	/**
	 * Method to convert Java Timestamps to Stata Datetimes
	 * @param datetime  A timestamp object returned from the JDBC query
	 * @return A long integer containing the number of milliseconds past the
	 * Stata epoch (01jan1960) precision milliseconds elapsed since
	 * 01jan1960.  The value can be displayed correctly in Stata using the
	 * %tc format.
	 */
	public String[] toStata(FileTime datetime) {

		// Strings with the date pieces
		String month, day, year, hour, minute, second, zone, offset;

		// Convert the FileTime object into the number of Milliseconds since
		// the Java epoch date
		ZonedDateTime zdt = ZonedDateTime.ofInstant(datetime.toInstant(), zid);

		// Year value
		year = String.valueOf(zdt.getYear());

		// Day of year (numeric) value
		if (String.valueOf(zdt.getDayOfMonth()).length() == 2) day = String.valueOf(zdt.getDayOfMonth());
		else day = "0" + String.valueOf(zdt.getDayOfMonth());

		// Month of year (string) value
 		month = zdt.getMonth().toString().toLowerCase().substring(0, 3);

		// Hour of the day value
		if (String.valueOf(zdt.getHour()).length() == 2) hour = String.valueOf(zdt.getHour());
		else hour = "0" + String.valueOf(zdt.getHour());

		// Minute of the hour value
		if (String.valueOf(zdt.getMinute()).length() == 2) minute = String.valueOf(zdt.getMinute());
		else minute = "0" + String.valueOf(zdt.getMinute());

		// Second of the minute value
		if (String.valueOf(zdt.getSecond()).length() == 2) second = String.valueOf(zdt.getSecond());
		else second = "0" + String.valueOf(zdt.getSecond());

		// The time zone ID America/Chicago
		zone = zdt.getZone().toString();

		// The Offset value
		offset = zdt.getOffset().getId();

		// String array returned by the method
		String[] retval = {day, month, year, hour, minute, second, zone, offset};

		// Returns a String array that can be used to construct a Stata
		// string that can be formatted as a date time variable
		return retval;

	} // End of Method declaration for FileTime objects

	/***
	 * Method that returns a String formatted to be included in Stata date
	 * function like date(retval, "YMDHms")
	 * @param toStata A string array created by the toStata method used for
	 *                   FileTime objects
	 * @return A String with the date and time prepared for use in Stata.
	 */
	public String stringArrayToStataDate(String[] toStata) {
		return toStata[0] + toStata[1] + toStata[2] + " " + toStata[3] +
				":" + toStata[4] + ":" + toStata[5];
	}

} // End of StataXTTS object declaration
