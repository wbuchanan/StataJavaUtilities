package org.paces.Stata.Observations;

import java.util.*;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class Observations {

	protected ObsInterface obs;

	private Integer version;

	public Observations(Double callerVersion) {
		this.version = callerVersion.intValue();
		if (version < 14) this.obs = new Obs13();
		else this.obs = new Obs14();
	}

	/**
	 * Returns an iterator over the observation indices in the dataset
	 * @return An iterator of type Integer (Stata 13) or type Long (Stata 14
	 * and later) that provides a consistent API for iterations over
	 * observations
	 */
	public Iterator<Number> getIterator() {
		return this.obs.getIterator();
	}

	/***
	 * @return the starting observation index value
	 */
	public Number getSobs() {
		return this.obs.getSobs();
	}

	/***
	 * @return the ending observation index value
	 */
	public Number getEobs() {
		return this.obs.getEobs();
	}

	/***
	 * @return the total number of observations
	 */
	public Number getNobs() {
		return this.obs.getNobs();
	}

	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that
	 * identify observation index values for data accessors and setters
	 */
	public List<Number> getObservationIndex() {
		return this.obs.getObservationIndex();
	}


}
