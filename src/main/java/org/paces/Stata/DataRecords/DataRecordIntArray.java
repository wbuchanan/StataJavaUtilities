package org.paces.Stata.DataRecords;

import com.stata.sfi.Data;
import org.paces.Stata.DataTypes.StTypes;
import org.paces.Stata.MetaData.Meta;

import java.util.*;

/***
 * Creates an Array of Integers for Individual Observation
 *
 * @author Billy Buchanan
 * @version %G%
 *
 */
public class DataRecordIntArray implements Record {

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
	private Integer[] observation;

	/***
	 * Constructor method for DataRecordIntArray class
	 * @param id The observation index value for which to retrieve the data for
	 * @param metaobject A Meta class object containing metadata from the
	 *                      Stata dataset
	 *
	 */
	public DataRecordIntArray(Long id, Meta metaobject) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id);

	} // End declaration of constructor method

	/**
	 * Constructor for use with Stata 13 API
	 * @param id An Integer observation ID
	 * @param metaobject The Meta object from which the data are accessed
	 */
	public DataRecordIntArray(Integer id, Meta metaobject) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id);

	} // End declaration of constructor method

	/**
	 * Constructor for use with Stata 13 API
	 * @param id An Integer observation ID
	 * @param metaobject The Meta object from which the data are accessed
	 * @param missingValue User specified default missing value
	 */
	public DataRecordIntArray(Integer id, Meta metaobject, Number
		missingValue) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id, missingValue);

	} // End declaration of constructor method

	/***
	 * Constructor method for DataRecordIntArray class
	 * @param id The observation index value for which to retrieve the data for
	 * @param metaobject A Meta class object containing metadata from the
	 *                      Stata dataset
	 * @param missingValue User specified default missing value
	 */
	public DataRecordIntArray(Long id, Meta metaobject, Number missingValue) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData(id, missingValue);

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

		Integer[] values = new Integer[metaob.getVarindex().size()];

		// Loop over the variable indices
		for (Integer i : metaob.getVarindex()) {

			// Check to see if value is missing
			if (Data.isValueMissing(Data.getNum(i, obid))) {

				// If value is missing, set value to -1.0
				values[i] = Integer.MAX_VALUE;

			} else {

				// Convert numeric variables to string
				values[i] = StTypes.asInteger(i, obid);

			} // End ELSE Block for non-missing values

		} // End of Loop

		// Set the observation value
		this.observation = values;

	} // End of setData method declaration

	/***
	 * Constructs the object containing the data for the record
	 * @param obid The observation ID for which the data are to be extracted
	 */
	@Override
	public void setData(Integer obid) {

		Integer[] values = new Integer[metaob.getVarindex().size()];

		// Loop over the variable indices
		for (Integer i : metaob.getVarindex()) {

			// Check to see if value is missing
			if (Data.isValueMissing(Data.getNum(i, obid))) {

				// If value is missing, set value to -1.0
				values[i] = Integer.MAX_VALUE;

			} else {

				// Convert numeric variables to string
				values[i] = StTypes.asInteger(i, obid);

			} // End ELSE Block for non-missing values

		} // End of Loop

		// Set the observation value
		this.observation = values;

	} // End of setData method declaration

	/***
	 * Method to construct row object with user specified missing value
	 * override
	 *
	 * @param obid         The observation ID for which the data are to be
	 *                     retrieved
	 * @param missingValue The value to use if missing data are present
	 */
	@Override
	public void setData(Number obid, Number missingValue) {

		Integer[] values = new Integer[metaob.getVarindex().size()];

		// Loop over the variable indices
		for (Integer i : metaob.getVarindex()) {

			// Check to see if value is missing
			if (Data.isValueMissing(Data.getNum(i, obid.intValue()))) {

				// If value is missing, set value to -1.0
				values[i] = Integer.MAX_VALUE;

			} else {

				// Convert numeric variables to string
				values[i] = StTypes.asInteger(i, obid);

			} // End ELSE Block for non-missing values

		} // End of Loop

		// Set the observation value
		this.observation = values;

	}

	/***
	 * Retrieves the data for a given record
	 * @return An object with the values for variables of interest on a given
	 * observation
	 */
	@Override
	public Integer[] getData() {

		// Returns the array for the observation
		return this.observation;

	} // End of getData method declaration

	/**
	 * Method to retrieve the data as a List object
	 * @return The data in a List object
	 */
	public List<Integer> toList() {

		// Converts the array of objects into a List of the same objects
		return Arrays.asList(this.observation);

	} // End of the method declaration



} // End of Class declaration
