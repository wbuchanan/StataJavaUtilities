package org.paces.Stata.DataRecords;

/***
 * Defines methods for Objects that construct individual observation
 * records.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public interface Record {

	/***
	 * Method to set the observation index value for the record
	 * @param observationNumber An observation index value
	 */
	public void setObid(Long observationNumber);

	/***
	 * Method to set the observation index value for the record
	 * @param observationNumber An observation index value
	 */
	public void setObid(Integer observationNumber);

	/***
	 * Constructs the object containing the data for the record
	 * @param obid Observation ID for which data is to be retrieved
	 */
	public void setData(Long obid);

	/***
	 * Constructs the object containing the data for the record
	 * @param obid Observation ID for which data is to be retrieved
	 */
	public void setData(Integer obid);

	/***
	 * Method to construct row object with user specified missing value override
	 * @param obid The observation ID for which the data are to be retrieved
	 * @param missingValue The value to use if missing data are present
	 */
	public void setData(Number obid, Number missingValue);

	/***
	 * Retrieves the data for a given record
	 * @return An object with the values for variables of interest on a given
	 * observation
	 */
	public Object getData();


} // End of Interface Definition
