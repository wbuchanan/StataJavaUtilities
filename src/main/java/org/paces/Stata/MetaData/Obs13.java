package org.paces.Stata.MetaData;

import com.stata.sfi.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to construct object used to iterate over observations in Stata
 * dataset and to store metadata related to observations.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class Obs13 {

	/***
	 * Starting observation index number
	 */
	protected Integer sobs;

	/***
	 * Ending observation index number
	 */
	protected Integer eobs;

	/***
	 * Total Number of Observations
	 */
	protected Integer nobs;

	/***
	 * Observation indices
	 */
	protected List<Integer> obindex;

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
	public void setSobs() {
		this.sobs = Data.getParsedIn1();
	}

	/***
	 * Sets the starting observation index
	 */
	public void setEobs() {
		this.eobs = Data.getParsedIn2();
	}

	/***
	 * Sets the number of effective observations
	 */
	public void setNobs() {

		// Return the size of the list object
		this.nobs = (Integer) this.obindex.size();

	} // End Method returning the number of observations

	/***
	 * Sets a list of effective observation indices
	 * @param start The starting observation index
	 * @param end The ending observation index
	 */
	public void setObservationIndex(Integer start, Integer end) {

		// Initialize temp variable
		List tmp = new ArrayList<>();

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

	/***
	 * @return the starting observation index value
	 */
	public Integer getSobs() { return(this.sobs); }

	/***
	 * @return the ending observation index value
	 */
	public Integer getEobs() { return(this.eobs); }

	/***
	 *
	 * @return the number of effective observations
	 */
	public Integer getNobs() {
		return(this.nobs);
	}

	/***
	 * @return the list of effective observation indices
	 */
	public List<Integer> getObservationIndex() { return(this.obindex); }

} // End Class definition
