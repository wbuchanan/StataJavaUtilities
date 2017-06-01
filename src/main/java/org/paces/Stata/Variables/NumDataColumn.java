package org.paces.Stata.Variables;

import com.stata.sfi.*;
import org.paces.Stata.MetaData.Meta;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class to return all values of a single numeric Stata variable
 * @author Billy Buchanan
 * @version %G%
 *
 */
public class NumDataColumn {

	/***
	 * A Meta class object contains meta data for the dataset in memory
	 */
	public Meta metaob;

	/***
	 * A List of double values from a single variable
	 */
	public List<Double> colvar;

	private final Integer ver = Double.valueOf(SFIToolkit.getCallerVersion()).intValue();

	/***
	 * Generic constructor for the class
	 * @param varidx The variable index from which to get records
	 */
	public NumDataColumn(Integer varidx) {

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
	public void setData(Integer var) {

		// Temp variable to store results
		List<Double> dblvar = new ArrayList<>();

		if (this.ver == 13) {

			// Populate the temp variable
			dblvar.addAll(metaob.getObs13().stream().map(
				(Function<Integer, Double>) (ob) -> {
					return Data.getNum(metaob.getVarindex(var), ob);
				}).collect(Collectors.<Double>toList()));

		} else {

			// Populate the temp variable
			dblvar.addAll(metaob.getObs14().stream().map(
				(Function<Long, Double>) (ob) -> {
					return Data.getNum(metaob.getVarindex(var), ob);
				}).collect(Collectors.<Double>toList()));

		}

		// Set the member variable to the values of the temp variable
		this.colvar = dblvar;

	} // End of setter method declaration

	/***
	 * Getter method to retrieve the List class object containing values
	 * @return A List of Double objects containing the data from the Stata
	 * dataset in memory
	 */
	public List<Double> getData() { return this.colvar; }

	/***
	 * Getter method to retrieve the data as an Array
	 * @return An array of Doubles containing values form the Stata dataset
	 * in memory
	 */
	public Double[] getDataAsDoubleArray() {

		// Get the length of the vector
		Integer x = this.colvar.size();

		// Initialize a new array class object with the same length
		Double[] y = new Double[x];

		// Returns the converted list object as an array
		return(this.colvar.toArray(y));

	} // End of method declaration

} // End of numeric data column class
