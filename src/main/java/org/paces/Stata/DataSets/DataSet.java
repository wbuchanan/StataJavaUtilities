package org.paces.Stata.DataSets;

import joinery.DataFrame;
import org.paces.Stata.DataRecords.DataRecord;
import org.paces.Stata.MetaData.DataSource;
import org.paces.Stata.MetaData.Meta;
import org.paces.Stata.Variables.DataColumn;

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

	/***
	 * Method to retrieve a single record of values
	 * @param record The integer value of the first index in the 2d Array
	 * @return An array of bytes
	 */
	@Override
	public Object getData(Integer record) {

		// Returns a single row of data from the dataset object
		return this.stataDataSet.get(record);

	} // End overloaded getter method declaration

	/***
	 * Method to retrieve a datum from the dataset object
	 * @param record The integer value of the first index of the 2d array
	 * @param var The integer value of the variable index to retrieve
	 * @return An object containing the datum[i, j] of the data set
	 */
	@Override
	public Object getData(Integer record, Integer var) {

		// Gets the name of the variable at index var
		String varnm = this.metaob.getStatavars().getVariableName(var);

		// Returns a single datum[i, j] from the dataset object
		// where i is passed as the parameter record and
		// j is passed as the parameter var
		DataRecord row = (DataRecord) this.stataDataSet.get(record);

		// Returns the value for the ith observation on the jth variable
		return row.getData().get(varnm);

	} // End overloaded getter method declaration

	/***
	 * Converts the dataset into a list of variable values nested within a
	 * list of records
	 * @return A List of Objects containing the datum[i, j] nested within a
	 * List containing the data[i, j...n]
	 */
	@Override
	public Object toList() {

		// Initializes the object to store the data that will be returned by
		// this method
		List<List<Object>> dataset = new ArrayList<>();

		// Starts loop over the record indices
		for (int i = 0; i < this.metaob.getObsindex().size(); i++) {

			// Initializes an object to store the values for a given record
			List<Object> record = new ArrayList<>();

			// Starts loop over the individual variables
			for (int j = 0; j < this.metaob.getVarindex().size(); j++) {

				// Adds the datum to the record object using the getData
				// method with the row and column indices passed as arguments
				record.add(j, getData(i, j));

			} // Ends the loop over the variables

			// Adds the complete record to the object initialized at the
			// beginning of the method
			dataset.add(i, record);

		} // Ends the loop over the observations

		// Returns the List object
		return dataset;

	} // End of Method declaration

	/**
	 * Method to try coercing the dataset object to a joinery.DataFrame class
	 * object
	 * @return A DataFrame object
	 */
	@SuppressWarnings("unchecked")
	public DataFrame toDataFrame() {
		List<List<?>> dataset = new ArrayList<>();
		for(Integer i : this.metaob.getVarindex()) {
			DataColumn dc = new DataColumn(i);
			dataset.add(dc.getData());
		}
		return new DataFrame(dataset);
	}

} // End Class declaration


