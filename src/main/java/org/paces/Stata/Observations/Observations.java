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
		this.version = Integer.valueOf(callerVersion.toString());
		if (version < 14) this.obs = new Obs13();
		else this.obs = new Obs14();
	}

	/**
	 * Returns an iterator over the observation indices in the dataset
	 * @return An iterator of type Integer (Stata 13) or type Long (Stata 14
	 * and later) that provides a consistent API for iterations over
	 * observations
	 */
	public Iterator getIterator() {
		return this.obs.getIterator();
	};

	/***
	 * @return the starting observation index value
	 */
	public Object getSobs() {
		if (this.version < 14) return this.obs.getSobs(Integer.valueOf(1));
		else return this.obs.getSobs(Long.valueOf(1L));
	};

	/***
	 * @return the ending observation index value
	 */
	public Object getEobs() {
		if (this.version < 14) return this.obs.getEobs(Integer.valueOf(1));
		else return this.obs.getEobs(Long.valueOf(1L));
	};

	/***
	 * @return the total number of observations
	 */
	public Object getNobs() {
		if (this.version < 14) return this.obs.getNobs(Integer.valueOf(1));
		else return this.obs.getNobs(Long.valueOf(1L));
	};

	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that
	 * identify observation index values for data accessors and setters
	 */
	public List getObservationIndex() {
		return this.obs.getObservationIndex();
	};


}
