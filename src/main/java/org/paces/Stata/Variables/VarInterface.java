package org.paces.Stata.Variables;

import java.util.Iterator;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 */
public interface VarInterface {

	/**
	 * Method used to return the appropriate iterator needed to iterate over
	 * the values stored in the object
	 * @return An Iterator object
	 */
	Iterator getIterator();


}
