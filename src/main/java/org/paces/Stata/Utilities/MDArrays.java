package org.paces.Stata.Utilities;

import java.util.*;

/**
 * Class with methods for converting two-dimensional arrays between object
 * and primitive types
 * @author Billy Buchanan
 * @version %G%
 */
public class MDArrays {

	/**
	 * Method to convert a 2D Object array to a 2D primitive array
	 * @param thedata A two-dimensional array of Bytes
	 * @return A two-dimensional array of bytes
	 */
	public static byte[][] toPrimative(Byte[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		byte[][] retdata = new byte[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D Object array to a 2D primitive array
	 * @param thedata A two-dimensional array of Doubles
	 * @return A two-dimensional array of doubles
	 */
	public static double[][] toPrimative(Double[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		double[][] retdata = new double[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D Object array to a 2D primitive array
	 * @param thedata A two-dimensional array of Integer
	 * @return A two-dimensional array of ints
	 */
	public static int[][] toPrimative(Integer[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		int[][] retdata = new int[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D Object array to a 2D primitive array
	 * @param thedata A two-dimensional array of Longs
	 * @return A two-dimensional array of longs
	 */
	public static long[][] toPrimative(Long[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		long[][] retdata = new long[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D primitive array to a 2D Object array
	 * @param thedata A two-dimensional array of byte
	 * @return A two-dimensional array of Bytes
	 */
	public static Byte[][] toObject(byte[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		Byte[][] retdata = new Byte[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D primitive array to a 2D Object array
	 * @param thedata A two-dimensional array of double
	 * @return A two-dimensional array of Doubles
	 */
	public static Double[][] toObject(double[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		Double[][] retdata = new Double[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D primitive array to a 2D Object array
	 * @param thedata A two-dimensional array of int
	 * @return A two-dimensional array of Integers
	 */
	public static Integer[][] toObject(int[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		Integer[][] retdata = new Integer[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method to convert a 2D primitive array to a 2D Object array
	 * @param thedata A two-dimensional array of long
	 * @return A two-dimensional array of Longs
	 */
	public static Long[][] toObject(long[][] thedata) {
		Integer i = thedata.length;
		Integer j = thedata[0].length;
		Long[][] retdata = new Long[i][j];
		for(Integer v = 0; v < i; v++) {
			for(Integer x = 0; x < j; x++) {
				retdata[v][x] = thedata[v][x];
			}
		}
		return retdata;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Double>> toList(double[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Double>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Double> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Float>> toList(float[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Float>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Float> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Long>> toList(long[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Long>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Long> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Integer>> toList(int[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Integer>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Integer> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Byte>> toList(byte[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Byte>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Byte> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Short>> toList(short[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Short>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			List<Short> row = new ArrayList<>();
			for(Integer j = 0; j < vars; j++) {
				row.add(j, thedata[i][j]);
			}
			returnObject.add(i, row);
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Double>> toList(Double[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Double>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Float>> toList(Float[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Float>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Long>> toList(Long[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Long>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Integer>> toList(Integer[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Integer>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Byte>> toList(Byte[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Byte>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}

	/**
	 * Method that returns a List of Object type Lists containing the data
	 * @param thedata A two dimensional array of values
	 * @return A list of lists containing the object types
	 */
	public static List<List<Short>> toList(Short[][] thedata) {
		Integer obs = thedata.length;
		Integer vars = thedata[0].length;
		List<List<Short>> returnObject = new ArrayList<>();
		for(Integer i = 0; i < obs; i++) {
			returnObject.add(i, Arrays.asList(thedata[i]));
		}
		return returnObject;
	}


}
