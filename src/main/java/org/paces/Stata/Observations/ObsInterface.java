package org.paces.Stata.Observations;

import java.util.*;

/**
 * Interface for observation methods
 * @author Billy Buchanan
 * @version %G%
 */
public interface ObsInterface {

	/**
	 * Returns an iterator over the observation indices in the dataset
	 * @return An iterator of type Integer (Stata 13) or type Long (Stata 14
	 * and later) that provides a consistent API for iterations over
	 * observations
	 */
	Iterator<Number> getIterator();

	/***
	 * @return the starting observation index value
	 */
	Number getSobs();

	/***
	 * @return the ending observation index value
	 */
	Number getEobs();

	/***
	 * @return the total number of observations
	 */
	Number getNobs();

	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that
	 * identify observation index values for data accessors and setters
	 */
	List<Number> getObservationIndex();

} // End Interface declaration
