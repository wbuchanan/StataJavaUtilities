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
public class Obs14 implements ObsInterface {

	/**
	 * Member used to pass type parameters to accessor methods
	 */
	protected Long dataType = Long.valueOf("1");

	/***
	 * Starting observation index number
	 */
	private Long sobs;

	/***
	 * Ending observation index number
	 */
	private Long eobs;

	/***
	 * Total Number of Observations
	 */
	private Long nobs;

	/***
	 * Observation indices
	 */
	private List<Number> obindex;

	/***
	 * Constructor method for class ObservationsImpl
	 */
	public Obs14() {

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
		this.sobs = Data.getObsParsedIn1();
	}

	/***
	 * Sets the starting observation index
	 */
	private void setEobs() {
		this.eobs = Data.getObsParsedIn2();
	}

	/***
	 * Sets the number of effective observations
	 */
	private void setNobs() {

		// Return the size of the list object
		this.nobs = (long) this.obindex.size();

	} // End Method returning the number of observations

	/***
	 * Sets a list of effective observation indices
	 * @param start The starting observation index
	 * @param end The ending observation index
	 */
	private void setObservationIndex(Long start, Long end) {

		// Initialize temp variable
		List<Number> tmp = new ArrayList<>();

		// Loop over the observations
		for(Long i = start; i <= end; i++) {

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
	 * Returns an iterator over the observation indices in the dataset
	 *
	 * @return An iterator of type Integer (Stata 13) or type Long (Stata 14 and
	 * later) that provides a consistent API for iterations over observations
	 */
	@Override
	public Iterator<Number> getIterator() {
		return this.obindex.iterator();
	}

	/***
	 * @return the starting observation index value
	 */
	@Override
	public Long getSobs() {
		return this.sobs;
	}

	/***
	 * @return the ending observation index value
	 */
	@Override
	public Long getEobs() {
		return this.eobs;
	}

	/***
	 * @return the total number of observations
	 */
	@Override
	public Long getNobs() {
		return this.nobs;
	}

	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 *
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that identify
	 * observation index values for data accessors and setters
	 */
	@Override
	public List<Number> getObservationIndex() {
		return this.obindex;
	}

} // End Class definition
