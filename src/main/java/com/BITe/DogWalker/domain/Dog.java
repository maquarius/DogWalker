package com.BITe.DogWalker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dogId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dog")
	private List<WalkEvent> walkEvent;

	@ManyToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	private String name, specialNeeds;
	private int weight;

	public Dog() {

	}

	public Dog( Owner owner, String name, String specialNeeds, int weight) {
		super();
		this.owner = owner;
		this.name = name;
		this.specialNeeds = specialNeeds;
		this.weight = weight;
	}

	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}

	public List<WalkEvent> getWalkEvent() {
		return walkEvent;
	}

	public void setWalkEvent(List<WalkEvent> walkEvent) {
		this.walkEvent = walkEvent;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
