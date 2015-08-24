/**
 * 
 */
package com.anil.model;

import java.util.List;
import java.util.Map;

/**
 * @author anila
 * 
 */
public class CMSPageContent {
	private String currentTip;
	private List<String> movieList;
	private Map<String, Employee> employeeList;

	/**
	 * @return the currentTip
	 */
	public String getCurrentTip() {
		return currentTip;
	}

	/**
	 * @param currentTip
	 *            the currentTip to set
	 */
	public void setCurrentTip(String currentTip) {
		this.currentTip = currentTip;
	}

	/**
	 * @return the movieList
	 */
	public List<String> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<String> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the employeeList
	 */
	public Map<String, Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(Map<String, Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
