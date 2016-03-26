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
	 * Retrieves the data for a given record
	 * @return An object with the values for variables of interest on a given
	 * observation
	 */
	public Object getData();


} // End of Interface Definition
