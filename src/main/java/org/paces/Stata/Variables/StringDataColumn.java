package org.paces.Stata.Variables;

import com.stata.sfi.*;
import org.paces.Stata.MetaData.Meta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class to return all values of a single variable
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class StringDataColumn {

	/***
	 * A Meta class object contains meta data for the dataset in memory
	 */
	public Meta metaob;

	/***
	 * A List of String values from a single variable
	 */
	public List<String> colvar;

	private final Integer ver = Double.valueOf(SFIToolkit.getCallerVersion()).intValue();

	/***
	 * Generic constructor for the class
	 * @param varidx The variable index from which to get records
	 */
	public StringDataColumn(Integer varidx) {

		// Populates the Meta class member variable
		metaob = new Meta();

		// Sets the values in the object based on a variable from the Stata
		// dataset
		setData(varidx) ;

	} // End Class constructor method

	/***
	 * Setter method used to retrieve the data from Stata and populate the
	 * member variable
	 * @param var The variable index to retrieve
	 */
	public void setData(int var) {

		// Temp variable to store results
		List<String> stringvar = new ArrayList<String>();

		if (this.ver == 13) {

			// Populate the temp variable
			stringvar.addAll(metaob.getObs13().stream().map(
				(Function<Integer, String>) (ob) -> {
					return Data.getStr(metaob.getVarindex(var), ob);
				}).collect(Collectors.<String>toList()));

		} else {

			// Populate the temp variable
			stringvar.addAll(metaob.getObs14().stream().map(
				(Function<Long, String>) (ob) -> {
					return Data.getStr(metaob.getVarindex(var), ob);
				}).collect(Collectors.<String>toList()));

		}

		// Populate the temp variable
		stringvar.addAll(metaob.getObs14().stream().map(
				(Function<Long, String>) (ob) -> {
					return Data.getStr(metaob.getVarindex(var), ob);
				}).collect(Collectors.<String>toList()));

		// Set teh values of the member variable to the values of the temp
		// variable
		this.colvar = stringvar;

	}// End of setter method declaration

	/***
	 * Getter method to retrieve the List class object containing values
	 * @return A List of String objects containing the data from the Stata
	 * dataset in memory
	 */
	public List<String> getData() {
		return this.colvar;
	}  // End of getter method


	/***
	 * Getter method to retrieve the List class object containing values and
	 * convert it to a String array
	 * @return A Array of String objects containing the data from the Stata
	 * dataset in memory
	 */
	public String[] getDataAsArray() {

		// Get the size of the list object
		int x = this.colvar.size();

		// Initialize a string array of the same size
		String[] y = new String[x];

		// Convert to array and return the string array
		return(this.colvar.toArray(y));

	} // End of getter method

} // End of string data column class
