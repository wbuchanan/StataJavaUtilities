package org.paces.Stata.Utilities;

/**
 * Class with methods for converting two-dimensional arrays between object
 * and primitive types
 * @author Billy Buchanan
 * @version 0.0.0
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
				retdata[v][x] = Byte.valueOf(thedata[v][x]);
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
				retdata[v][x] = Double.valueOf(thedata[v][x]);
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
				retdata[v][x] = Integer.valueOf(thedata[v][x]);
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
				retdata[v][x] = Long.valueOf(thedata[v][x]);
			}
		}
		return retdata;
	}


}
