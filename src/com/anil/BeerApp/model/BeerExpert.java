/*
 * Created on Dec 28, 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.BeerApp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aallewar
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class BeerExpert {

	public static final String[] lightList = { "Jack Ember", "Red Goose" };
	public static final String[] amberList = { "Fosters", "Corona Light" };
	public static final String[] brownList = { "KingFisher", "Mera No. 1" };
	public static final String[] darkList = { "BudWeiser", "Corona Strong" };

	/**
	 * 
	 */
	public BeerExpert() {

		// TODO Auto-generated constructor stub
	}

	public List<String> getBeerList(String color) {
		List<String> list = new ArrayList<String>();
		String colorList = color + "List";
		System.out.println("The selected color list is:" + colorList);
		if (("lightList").equals(colorList)) {
			list = Arrays.asList(lightList);
		} else if (("amberList").equals(colorList)) {
			list = Arrays.asList(amberList);
		} else if (("brownList").equals(colorList)) {
			list = Arrays.asList(brownList);
		} else {
			list = Arrays.asList(darkList);
		}

		return list;
	}
}
