package org.paces.Stata.MetaData;

import com.stata.sfi.*;
import org.paces.Stata.Observations.Observations;

import java.util.*;

/**
 * Class used for Stata's Java API to access dataset Metadata.
 * Initializes Observations and Variables objects to construct data for
 * individual records and the entire data set.  DataRecord and
 * DataSet objects inherit Meta to construct these representations.
 *
 * @author Billy Buchanan
 * @version 0.0.0
 *
 */
public class Meta {

	/***
	 * Observations metadata object
	 */
	private Observations stataobs;

	/***
	 * Variables metadata object
	 */
	private Variables statavars;

	/***
	 * Variable index metadata object
	 */
	private List<Integer> varindex;

	/***
	 * Observation index metadata object
	 */
	private List<Number> obsindex;

	/***
	 * Constructor for object w/o any arguments passed
	 * @param args Arguments passed from the javacall command in Stata
	 */
	@Deprecated
	public Meta(String[] args) {
		this();
	}

	/***
	 * Constructor for object w/o any arguments passed
	 */
	public Meta() {

		// Create an observations member variable
		setStataobs();

		// Create a variables member variable
		setStatavars();

		// Create a variable index member variable
		setVarindex(statavars);

		// Create an observation index member variable
		setObsindex(stataobs);

	} // End constructor declaration

	/***
	 * Generic setter method for observations member variable
	 */
	private void setStataobs() {

		// Initialize a new observations object
		this.stataobs = new Observations(SFIToolkit.getCallerVersion());

	} // End setter method for observations member variable

	/***
	 * Generic setter method for variables member variable
	 */
	private void setStatavars() {

		// Initialize a new variables metadata object
		this.statavars = new Variables();

	} // End setter method for variables metadata member variable

	/***
	 * Sets teh observation index member variable
	 * @param observations An observations class object
	 */
	private void setObsindex(Observations observations) {

		// Initialize a new observation index object
		this.obsindex = observations.getObservationIndex();

	} // End setter method for observation index member variable

	/***
	 * Sets the variable index member variable
	 * @param variables A variables class object
	 */
	private void setVarindex(Variables variables) {

		// Initialize a new variable index object
		this.varindex = variables.getVariableIndex();

	} // End setter method for variable index member variable

	/***
	 * Getter for the observations member variable
	 * @return Returns the observation member variable
	 */
	public Observations getStataobs() { return this.stataobs; }

	/***
	 * Getter for the variables member variable
	 * @return Returns the variables member variable
	 */
	public Variables getStatavars() { return this.statavars; }

	/***
	 * Getter for the observation index for the Stata 14 API
	 * @return Returns the observation index member variable
	 */
	public List<Long> getObs14() {
		List<Long> stata14ObservationIndex = new ArrayList<>();
		for(Number i : this.obsindex) {
			stata14ObservationIndex.add(i.longValue());
		}
		return stata14ObservationIndex;
	}

	/***
	 * Getter for the observation index for the Stata 14 API
	 * @return Returns the observation index member variable
	 */
	public List<Integer> getObs13() {
		List<Integer> stata13ObservationIndex = new ArrayList<>();
		for(Number i : this.obsindex) {
			stata13ObservationIndex.add(i.intValue());
		}
		return stata13ObservationIndex;
	}

	/***
	 * Getter for the variable index member variable
	 * @return Returns the variable index member variable
	 */
	public List<Integer> getVarindex() { return this.varindex; }

	/***
	 * Getter for single variable index value
	 * @param idxid The variable index element whose value is to be retrieved
	 * @return The element of the variable index passed to the method call
	 */
	public Integer getVarindex(Integer idxid) {

		// Return the element of the variable index identified by the value
		// of the argument passed to the method
		return this.statavars.getVariableIndex(idxid);

	} // End getVarIndex method declaration

	public List<String> getVarNames() {
		return this.statavars.getVariableNames();
	}

	public String getVarName(Integer varIdx) {
		return this.statavars.getVariableName(varIdx);
	}

	public Map<String, Boolean> getAreStrings() {
		return this.statavars.getVariableTypes();
	}

	public Boolean getIsString(String varname) {
		return this.statavars.getVariableTypes().get(varname);
	}

	public Map<String, String> getValueLabelNames() {
		return this.statavars.getValueLabelNames();
	}

	public String getValueLabelName(String varname) {
		return this.statavars.getValueLabelNames().get(varname);
	}

	public Map<String, String> getVariableLabels() {
		return this.statavars.getVariableLabels();
	}

	public String getVariableLabel(String varname) {
		return this.statavars.getVariableLabels().get(varname);
	}

	public List<Number> getObsindex() {
		return this.obsindex;
	}



} // End object declaration
