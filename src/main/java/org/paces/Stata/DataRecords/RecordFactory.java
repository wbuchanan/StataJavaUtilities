package org.paces.Stata.DataRecords;

import org.paces.Stata.MetaData.Meta;

/**
 * Object used to initialize a DataRecord type object given an observation
 * ID, a Meta class object, and a string argument to define the return type.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class RecordFactory {

	/***
	 * Method to create a Record class object
	 * @param type A string argument defining what type of Record class
	 *                object to create
	 * @param obid An observation index defining which values to retrieve
	 *                from the Stata dataset in memory
	 * @param metaob An object of class Meta used to define the
	 *                  observation/variable indices and metadata overall
	 * @return A Record class object of type defined by the user.  An empty
	 * string will return the object used for JSON serialization
	 */
	public static Record recordFactory(String type, Long obid, Meta metaob) {

		// Dispatch class creation based on value of the argument passed to
		// the type parameter.
		switch (type) {

			// If type argument is 'byte'
			case "byte":

				// Return a Byte Array class data record
				return new DataRecordByteArray(obid, metaob);

			// If type argument is 'int'
			case "int":

				// Return an Integer Array class data record
				return new DataRecordIntArray(obid, metaob);

			// If type argument is 'long'
			case "long":

				// Return a Long Array class data record
				return new DataRecordLongArray(obid, metaob);

			// If type argument is 'double'
			case "double":

				// Return a Double Array class data record
				return new DataRecordDoubleArray(obid, metaob);

			// If type argument is 'string'
			case "string":

				// Return a String Array class data record
				return new DataRecordStringArray(obid, metaob);

			// If type argument is anything else
			default :

				// Return a Data record used for JSON serialization
				return new DataRecord(obid, metaob);

		} // End switch statement

	} // End Method declaration

	/***
	 * Method to create a Record class object
	 * @param type A string argument defining what type of Record class
	 *                object to create
	 * @param obid An observation index defining which values to retrieve
	 *                from the Stata dataset in memory
	 * @param metaob An object of class Meta used to define the
	 *                  observation/variable indices and metadata overall
	 * @return A Record class object of type defined by the user.  An empty
	 * string will return the object used for JSON serialization
	 */
	public static Record recordFactory(String type, Long obid, Meta metaob,
	                                   Number missingValue) {

		// Dispatch class creation based on value of the argument passed to
		// the type parameter.
		switch (type) {

			// If type argument is 'byte'
			case "byte":

				// Return a Byte Array class data record
				return new DataRecordByteArray(obid, metaob, missingValue);

			// If type argument is 'int'
			case "int":

				// Return an Integer Array class data record
				return new DataRecordIntArray(obid, metaob, missingValue);

			// If type argument is 'long'
			case "long":

				// Return a Long Array class data record
				return new DataRecordLongArray(obid, metaob, missingValue);

			// If type argument is 'double'
			case "double":

				// Return a Double Array class data record
				return new DataRecordDoubleArray(obid, metaob, missingValue);

			// If type argument is 'string'
			case "string":

				// Return a String Array class data record
				return new DataRecordStringArray(obid, metaob, missingValue);

			// If type argument is anything else
			default :

				// Return a Data record used for JSON serialization
				return new DataRecord(obid, metaob, missingValue);

		} // End switch statement

	} // End Method declaration

} // End Factory class declaration
