package org.paces.Stata.DataRecords;

import com.stata.sfi.Data;
import org.paces.Stata.MetaData.Meta;

/***
 * Creates an Array of Bytes for Individual Observation
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class DataRecordByteArray implements Record {

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
	private byte[] observation;

	/***
	 * Constructor method for DataRecordByteArray class
	 * @param id The observation index value for which to retrieve the data for
	 * @param metaobject A Meta class object containing metadata from the
	 *                      Stata dataset
	 *
	 */
	public DataRecordByteArray(Long id, Meta metaobject) {

		// The metadata object
		this.metaob = metaobject;

		// Set the observation ID variable
		setObid(id);

		// Set the data (observation) variable
		setData();

	} // End declaration of constructor method

	/***
	 * Method to set the observation index value for the record
	 * @param observationNumber An observation index value
	 */
	@Override
	public void setObid(long observationNumber) {

		// Sets the observation index value for the object
		this.obid = observationNumber;

	} // End of setObid method declaration

	/***
	 * Constructs the object containing the data for the record
	 */
	@Override
	public void setData() {

		byte[] values = new byte[metaob.varindex.size()];

		// Loop over the variable indices
		for (int i = 0; i < metaob.varindex.size(); i++) {

			// Check to see if value is missing
			if (Data.isValueMissing(Data.getNum(metaob.getVarindex(i), obid))) {

				// If value is missing, set value to -1.0
				values[i] = -1;

			} else {

				// Convert numeric variables to string
				values[i] = (byte) Math.round(Data.getNum(metaob
						.getVarindex(i), obid) / 1);

			} // End ELSE Block for non-missing values

		} // End of Loop

		// Set the observation value
		this.observation = values;

	} // End of setData method declaration

	/***
	 * Retrieves the data for a given record
	 *
	 * @return An object with the values for variables of interest on a given
	 * observation
	 */
	@Override
	public byte[] getData() {

		// Returns the array for the observation
		return this.observation;

	} // End of getData method declaration

} // End of Class declaration