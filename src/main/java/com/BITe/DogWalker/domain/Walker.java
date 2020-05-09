package com.BITe.DogWalker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Walker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long walkerId;

	private String firstName, lastName, email, adress;
	private int walkingRadius;
	private int phoneNumber;

	public Walker() {

	}

	public Walker(String firstName, String lastName, String email, String adress, int phoneNumber, int walkingRadius) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.walkingRadius = walkingRadius;
	}

	public Long getWalkerId() {
		return walkerId;
	}

	public void setWalkerId(long walkerId) {
		this.walkerId = walkerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getWalkingRadius() {
		return walkingRadius;
	}

	public void setWalkingRadius(int walkingRadius) {
		this.walkingRadius = walkingRadius;
	}

}
