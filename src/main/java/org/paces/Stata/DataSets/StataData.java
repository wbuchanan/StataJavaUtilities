package org.paces.Stata.DataSets;

/**
 * Interface used to access and construct representations of Stata data
 * set as POJOs.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public abstract interface StataData {

	/***
	 * 	Method to build the Stata data object
	 */
	void setData();

	/***
	 * Method to retrieve the entire 2d array of data
	 * @return A POJO containing a Stata data representation
	 */
	Object getData();

	/***
	 * Method to retrieve a single row of values
	 * @param record The integer value of the first index in the 2d Array
	 * @return An array of objects containing the data from the DataSet object
	 */
	Object getData(Integer record);

	/***
	 * Method to retrieve a datum from the dataset object
	 * @param record The integer value of the first index of the 2d array
	 * @param var The integer value of the second index of the 2d array
	 * @return An object containing the datum[i, j] of the data set
	 */
	Object getData(Integer record, Integer var);

	/***
	 * Converts the dataset into a list of variable values nested within a
	 * list of records
	 * @return A List of Objects containing the datum[i, j] nested within a
	 * List containing the data[i, j...n]
	 */
	Object toList();

} // End interface declaration
