package org.paces.Stata.DataRecords;

import com.stata.sfi.Data;
import org.paces.Stata.MetaData.Meta;

import java.util.*;

/***
 * Creates an Array of Strings for Individual Observation
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class DataRecordStringArray implements Record {

	/***
	 * A Stata Metadata object
	 */
	private Meta metaob;

	/***
	 * Observation ID variable
	 */
	private Long obid;

	/***
	 * Variable containing the data for a given observation
	 */
	private String[] observation;

	/***
	 * Constructor method for DataRecordStringArray class
	 * @param id The observation index value for which to retrieve the data for
	 * @param metaobject A Meta class object containing metadata from the
	 *                      Stata dataset
	 *
	 */
	public DataRecordStringArray(Long id, Meta metaobject) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id);

	} // End declaration of constructor method

	/***
	 * Constructor method for DataRecordStringArray class
	 * @param id The observation index value for which to retrieve the data for
	 * @param metaobject A Meta class object containing metadata from the
	 *                      Stata dataset
	 *
	 */
	public DataRecordStringArray(Integer id, Meta metaobject) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id);

	} // End declaration of constructor method


	/***
	 * Method to set the observation index value for the record
	 * @param observationNumber An observation index value
	 */
	@Override
	public void setObid(Long observationNumber) {

		// Sets the observation index value for the object
		this.obid = observationNumber;

	} // End of setObid method declaration

	/***
	 * Method to set the observation index value for the record
	 * @param observationNumber An observation index value
	 */
	@Override
	public void setObid(Integer observationNumber) {

		// Sets the observation index value for the object
		this.obid = Long.valueOf(observationNumber);

	} // End of setObid method declaration

	/***
	 * Constructs the object containing the data for the record
	 * @param obid The observation ID for which the data are to be extracted
	 */
	@Override
	public void setData(Long obid) {
		
		String[] values = new String[metaob.varindex.size()];

		// Loop over the variable indices
		for (Integer i : metaob.getVarindex()) {

			// Convert numeric variables to string
			values[i] = Data.getStr(i, obid);

		} // End of Loop

		// Set the observation value
		this.observation = values;

	} // End of setData method definition

	/***
	 * Constructs the object containing the data for the record
	 * @param obid The observation ID for which the data are to be extracted
	 */
	@Override
	public void setData(Integer obid) {

		String[] values = new String[metaob.varindex.size()];

		// Loop over the variable indices
		for (Integer i : metaob.getVarindex()) {

			// Convert numeric variables to string
			values[i] = Data.getStr(i, obid);

		} // End of Loop

		// Set the observation value
		this.observation = values;

	} // End of setData method definition

	/***
	 * Retrieves the data for a given record
	 * @return An object with the values for variables of interest on a given
	 * observation
	 */
	@Override
	public String[] getData() {

		// Returns the array for the observation
		return this.observation;

	} // End of getData method declaration

	/**
	 * Method to retrieve the data as a List of String objects
	 * @return The data in a List object
	 */
	public List<String> toList() {

		// Converts the array of objects into a List of the same objects
		return Arrays.asList(this.observation);

	} // End of the method declaration

} // End of Class declaration
