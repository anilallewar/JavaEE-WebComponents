package com.anil.model;

/**
 * This class will be used through the EL to return value of dice
 * 
 * @author anila
 * 
 */
public class DiceRoller {

	public static int rollDice(int probability) {
		
		int value = ((int) (Math.random() * probability)) + 1;
		System.out
				.println("The random value obtained with probability: "
						+ probability + " is: "
						+ value);
		return value;
	}
}
