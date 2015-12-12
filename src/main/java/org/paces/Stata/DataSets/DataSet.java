package org.paces.Stata.DataSets;

import org.paces.Stata.DataRecords.DataRecord;
import org.paces.Stata.MetaData.DataSource;
import org.paces.Stata.MetaData.Meta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A POJO representation of the Stata dataset currently in memory.
 * Created by iterating over calls to DataRecord.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class DataSet implements StataData {

	/***
	 * A new Meta object
	 */
	public Meta metaob;

	/***
	 * The name of the data set in memory to be converted to a JSON object
	 */
	private final String source = DataSource.get();

	/***
	 * The name of the Object
	 */
	private final String name = "DataSet";

	/***
	 * POJO Representation of the data set in memory of Stata
	 */
	public List<Object> stataDataSet;

	/***
	 * Generic constructor method for the class
	 * @param metaobject A Meta class object containing metadata for the
	 *                      Stata dataset.
	 */
	public DataSet(Meta metaobject) {

		// Set the meta object to the value passed to the constructor
		this.metaob = metaobject;

		// Builds the data object
		setData();

	} // End constructor declaration

	/***
	 * Method to store Stata dataset in a List of objects containing maps of
	 * key value pairs where the key is the variable name and the value is
	 * the value on that variable for the given observation
	 */
	@Override
	public void setData() {

		// Initialize container to ID the observation and contains a Map
		// object with key/value pairs
		List<Object> obs = new ArrayList<Object>();

		obs.addAll(metaob.obsindex.stream().map(
				(Function<Long, Object>) (id) -> {
					return new DataRecord(id, this.metaob).getData();
				}
		).collect(Collectors.<Object>toList()));

		// Set the member variable to this value
		stataDataSet = obs;

	} // End method declaration to set data value of class

	/***
	 * Getter method to access the POJO representation of the Stata dataset
	 * @return A POJO representation of the Stata Dataset
	 */
	@Override
	public Object getData() {

		// Returns the sole member variable of the class
		return this.stataDataSet;

	} // End getter method declaration

	/***
	 * Getter method to the name of the Object
	 * @return The name of the Stata Data object
	 */
	public String getSource() {

		// Returns the name of the Stata dataset (or generic placeholder)
		// used to construct a JSON object
		return this.source;

	} // End of getName method declaration

	/***
	 * Method to retrieve the name property of the object
	 * @return A string containing the name of the object
	 */
	public String getName() {
		return this.name;
	}

} // End Class declaration


