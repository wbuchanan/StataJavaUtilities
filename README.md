[![Project Status: Active - The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)

# Stata Java Utilities
Classes that should hopefully make it easier for others to use the Java API 
available in Stata.  This repository contains classes and methods that will 
allow you to construct a complete representation of a Stata dataset (loaded 
into the current Stata session) on the JVM including: variable labels, value 
labels, variable names, value label names, the data, etc....  

## News
Additional getter methods have been added to the DataSets package classes to 
enable retrieving a single record, indivdual datum, and a List representation
 of the dataset object.  The StataMissings class also includes values 
 corresponding to the set of extended missing values for the `float` and 
 `double` types.  The additions to this class also include a method that will
  return the String mask for the extended missing value for any type.  Other 
  than the methods that return NavigableMap type objects, all methods in the 
  class are overloaded to make it easier to code without worrying about 
  needing to remember type specific implementations of the methods.

