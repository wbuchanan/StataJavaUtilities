package org.paces.Stata.Utilities;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import static java.time.temporal.ChronoUnit.MILLIS;
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
	 * Constant for the Stata Epoch date
	 */
	public static final Instant STATAEPOCH =
			LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);

	/***
	 * Constant for the Java Epoch date
	 */
	public static final Instant JAVAEPOCH =
			LocalDateTime.of(1960, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);

	/***
	 * Constant for the Stata to Java offset
	 */
	public static final Instant STATAOFFSET =
			STATAEPOCH.minusMillis(JAVAEPOCH.toEpochMilli());

	/**
	 * Method to convert Java Dates to Stata Dates
	 * @param datetime A date object to convert to a Stata datetime value
	 * @return Double precision milliseconds elapsed since 01jan1960
	 */
	public static double toStata(Date datetime) {

		// Convert to a local date object
		LocalDate dbLocalDate = datetime.toLocalDate();

		// Return the date value with the epoch date adjusted
		return dbLocalDate.minusYears(10).toEpochDay();

	} // End toStata method declaration for Date object classes

	/**
	 * Method to convert Java Times to Stata Datetimes
	 * @param datetime A time object returned from the JDBC query
	 * @return Double precision milliseconds elapsed since 01jan1960
	 */
	public static double toStata(Time datetime) {

		// Convert to a local time object
		LocalTime dbLocalTime = datetime.toLocalTime().minus(10, YEARS);

		// Return the double value to convert to a Stata value
		return dbLocalTime.toNanoOfDay();

	} // End toStata method declaration for Time object classes

	/**
	 * Method to convert Java Timestamps to Stata Datetimes
	 * @param datetime  A timestamp object returned from the JDBC query
	 * @return Double precision milliseconds elapsed since 01jan1960
	 */
	public static double toStata(Timestamp datetime) {

		// Convert timestamp variable to an instant class object
		Instant javadate = datetime.toInstant();

		// Return the object with the time offset adjustment
		return javadate.plus(STATAOFFSET.toEpochMilli(), MILLIS).toEpochMilli();

	} // End toStata method declaration for Timestamp object classes

} // End of StataXTTS object declaration
