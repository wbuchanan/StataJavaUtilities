package org.paces.Stata.Variables;

import java.util.Map;

/**
 * @author Billy Buchanan
 * @version 0.0.0
 */
public interface StataTypeInterface {

	default Integer getStataType(Map<String, Integer> typeMap, String type) {
		return typeMap.get(type);
	}

}
