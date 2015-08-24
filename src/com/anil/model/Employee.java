package com.anil.model;

import com.anil.listenerexample.model.Dog;

public class Employee extends Person {
	private int employeeId;
	private Dog pet;

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the pet
	 */
	public Dog getPet() {
		return pet;
	}

	/**
	 * @param pet
	 *            the pet to set
	 */
	public void setPet(Dog pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return (this.employeeId + "-" + this.getName() + "-Pet Dog:" + ((this.pet == null) ? null
				: this.pet.getBreed()));
	}
}
