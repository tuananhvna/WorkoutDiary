package com.example.WorkoutDiary.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Muscle {
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long muscleid;
	private String name;
	
	
	//one to many relationship
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "muscle", fetch = FetchType.LAZY)
	private List<Workout> workouts;
	
	//constructors
	public Muscle() {
		
	}

	public Muscle(String name) {
		super();
		this.name = name;
	}
	
	//getters and setters
	public Long getMuscleid() {
		return muscleid;
	}

	public void setMuscleid(Long muscleid) {
		this.muscleid = muscleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "Muscle [muscleid=" + muscleid + ", name=" + name + "]";
	}

}
