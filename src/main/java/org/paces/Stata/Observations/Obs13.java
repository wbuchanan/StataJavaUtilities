package org.paces.Stata.Observations;

import com.stata.sfi.*;

import java.util.*;

/**
 * Class to construct object used to iterate over observations in Stata
 * dataset and to store metadata related to observations.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class Obs13 implements ObsInterface {

	/**
	 * Member used to pass type parameters to accessor methods
	 */
	protected Integer dataType = Integer.valueOf("1");

	/***
	 * Starting observation index number
	 */
	private Integer sobs;

	/***
	 * Ending observation index number
	 */
	private Integer eobs;

	/***
	 * Total Number of Observations
	 */
	private Integer nobs;

	/***
	 * Observation indices
	 */
	private List<Number> obindex;

	/***
	 * Constructor method for class ObservationsImpl
	 */
	public Obs13() {


		// Set the starting observation index
		setSobs();

		// Set the ending observation index
		setEobs();

		// Set the observation indices
		setObservationIndex(this.sobs, this.eobs);

		// Set the total number of observations
		setNobs();

	} // End of constructor definition

	/***
	 * Sets the starting observation index
	 */
	private void setSobs() {
		this.sobs = Data.getParsedIn1();
	}

	/***
	 * Sets the starting observation index
	 */
	private void setEobs() {
		this.eobs = Data.getParsedIn2();
	}

	/***
	 * Sets the number of effective observations
	 */
	private void setNobs() {

		// Return the size of the list object
		this.nobs = Integer.valueOf(this.obindex.size());

	} // End Method returning the number of observations

	/***
	 * Sets a list of effective observation indices
	 * @param start The starting observation index
	 * @param end The ending observation index
	 */
	private void setObservationIndex(Integer start, Integer end) {

		// Initialize temp variable
		List<Number> tmp = new ArrayList<>();

		// Loop over the observations
		for(Integer i = start; i <= end; i++) {

			// Test whether the observation satisfies an existing if condition
			if (!Data.isParsedIfTrue(i)) continue;

			//noinspection unchecked
			tmp.add(i);

		} // End Loop over observations

		// Set the observation index member value based on the local ArrayList
		//noinspection unchecked
		this.obindex = tmp;

	} // End method definition to set observation index


	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that
	 * identify observation index values for data accessors and setters
	 */
	@Override
	public List<Number> getObservationIndex() {
		return(this.obindex);
	}


	/**
	 * Returns an iterator over the observation indices in the dataset
	 *
	 * @return An iterator of type Integer (Stata 13) or type Integer (Stata 14
	 * and later) that provides a consistent API for iterations over
	 * observations
	 */
	@Override
	public Iterator<Number> getIterator() {

		// Returns the list of observation indices as an iterator object
		return this.obindex.iterator();

	} // End getIterator method

	/***
	 * @return the starting observation index value
	 */
	@Override
	public Integer getSobs() {
		return(this.sobs);
	}

	/***
	 * @return the ending observation index value
	 */
	@Override
	public Integer getEobs() {
		return this.eobs;
	}

	/***
	 * @return the total number of observations
	 */
	@Override
	public Integer getNobs() {
		return this.nobs;
	}

} // End Class definition
