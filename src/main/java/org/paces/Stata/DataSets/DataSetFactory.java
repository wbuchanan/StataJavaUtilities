package org.paces.Stata.DataSets;

import org.paces.Stata.MetaData.Meta;

/**
 * Object used to initialize DataSet class objects given the dataset meta
 * data and an argument defining the return type to be created by the
 * method.
 *
 * @author Billy Buchanan
 * @version %G%
 *
 */
public class DataSetFactory {

	/***
	 * Method to create a DataSet class object
	 * @param type A string argument defining what type of Set class
	 *                object to create
	 * @param metaob An object of class Meta used to define the
	 *                  observation/variable indices and metadata overall
	 * @return A Data Set class object of type defined by the user.  An empty
	 * string will return the object used for JSON serialization
	 */
	public static StataData dataSetFactory(String type, Meta metaob) {

		// Dispatch class creation based on value of the argument passed to
		// the type parameter.
		switch (type) {

			// If type argument is 'byte'
			case "byte":

				// Return a Byte Array class data Set
				return new DataSetByteArrays(metaob);

			// If type argument is 'int'
			case "int":

				// Return an Integer Array class data Set
				return new DataSetIntArrays(metaob);

			// If type argument is 'long'
			case "long":

				// Return a Long Array class data Set
				return new DataSetLongArrays(metaob);

			// If type argument is 'double'
			case "double":

				// Return a Double Array class data Set
				return new DataSetDoubleArrays(metaob);

			// If type argument is 'string'
			case "string":

				// Return a String Array class data Set
				return new DataSetStringArrays(metaob);

			// If type argument is anything else
			default :

				// Return a Data Set used for JSON serialization
				return new DataSet(metaob);

		} // End switch statement

	} // End Method declaration

} // End dataset factory class declaration
