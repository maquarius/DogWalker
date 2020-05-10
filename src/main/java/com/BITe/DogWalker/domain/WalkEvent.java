package com.BITe.DogWalker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WalkEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long walkId;

	@ManyToOne
	@JoinColumn(name = "dogId")
	private Dog dog;

	@ManyToOne
	@JoinColumn(name = "walkerId")
	private Walker walker;

	private String startingAdress, specialComments, date, time, endAdress;

	private int compensation;

	public WalkEvent() {

	}

	public WalkEvent(Dog dog, Walker walker, String startingAdress, String specialComments, String date, String time,
			String endAdress, int compensation) {
		super();
		this.dog = dog;
		this.walker = walker;
		this.startingAdress = startingAdress;
		this.specialComments = specialComments;
		this.date = date;
		this.time = time;
		this.endAdress = endAdress;
		this.compensation = compensation;
	}

	public Long getWalkId() {
		return walkId;
	}

	public void setWalkId(Long walkId) {
		this.walkId = walkId;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Walker getWalker() {
		return walker;
	}

	public void setWalker(Walker walker) {
		this.walker = walker;
	}

	public String getStartingAdress() {
		return startingAdress;
	}

	public void setStartingAdress(String startingAdress) {
		this.startingAdress = startingAdress;
	}

	public String getSpecialComments() {
		return specialComments;
	}

	public void setSpecialComments(String specialComments) {
		this.specialComments = specialComments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEndAdress() {
		return endAdress;
	}

	public void setEndAdress(String endAdress) {
		this.endAdress = endAdress;
	}

	public int getCompensation() {
		return compensation;
	}

	public void setCompensation(int compensation) {
		this.compensation = compensation;
	}

}
