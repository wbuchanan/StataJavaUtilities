package org.paces.Stata.Observations;

import java.util.*;

/**
 * Interface for observation methods
 * @author Billy Buchanan
 * @version 0.0.0
 */
public interface ObsInterface {

	/**
	 * Returns an iterator over the observation indices in the dataset
	 * @return An iterator of type Integer (Stata 13) or type Long (Stata 14
	 * and later) that provides a consistent API for iterations over
	 * observations
	 */
	Iterator getIterator();

	/***
	 * @param <T> The type to be returned.  Should be Integer for Stata 13
	 *              API or Long for Stata 14 and later APIs
	 * @param dataType A class object which should be used to cast the return
	 *                    object
	 * @return the starting observation index value
	 */
	@SuppressWarnings("unchecked")
	<T> T getSobs(T dataType);

	/***
	 * @param <T> The type to be returned.  Should be Integer for Stata 13
	 *              API or Long for Stata 14 and later APIs
	 * @param dataType A class object which should be used to cast the return
	 *                    object
	 * @return the ending observation index value
	 */
	@SuppressWarnings("unchecked")
	<T> T getEobs(T dataType);

	/***
	 * @param <T> The type to be returned.  Should be Integer for Stata 13
	 *              API or Long for Stata 14 and later APIs
	 * @param dataType A class object which should be used to cast the return
	 *                    object
	 * @return the total number of observations
	 */
	@SuppressWarnings("unchecked")
	<T> T getNobs(T dataType);

	/**
	 * Method used to return the list of observation indices for the current
	 * dataset
	 * @return A List of Integers (Stata 13) or Longs (Stata 14 or later) that
	 * identify observation index values for data accessors and setters
	 */
	List getObservationIndex();

} // End Interface declaration
