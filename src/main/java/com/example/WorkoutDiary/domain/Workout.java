package com.example.WorkoutDiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Workout {
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String exercise;
	private int weight;
	private int goalReps;
	private int reps;
	private int rpe;
	private int restTime;
	private int burnedCalo;
	
	@ManyToOne
	@JoinColumn(name = "muscleid")
	private Muscle muscle;
	
	//constructors
	public Workout() {
		
	}
	
	public Workout(String exercise, int weight, int goalReps, int reps, int rpe, int restTime,
			int burnedCalo, Muscle muscle) {
		super();
		this.exercise = exercise;
		this.weight = weight;
		this.goalReps = goalReps;
		this.reps = reps;
		this.rpe = rpe;
		this.restTime = restTime;
		this.burnedCalo = burnedCalo;
		this.muscle = muscle;
	}

	
	//getter, setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGoalReps() {
		return goalReps;
	}

	public void setGoalReps(int goalReps) {
		this.goalReps = goalReps;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getRpe() {
		return rpe;
	}

	public void setRpe(int rpe) {
		this.rpe = rpe;
	}

	public int getRestTime() {
		return restTime;
	}

	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}

	public int getBurnedCalo() {
		return burnedCalo;
	}

	public void setBurnedCalo(int burnedCalo) {
		this.burnedCalo = burnedCalo;
	}
	
	public Muscle getMuscle() {
		return muscle;
	}

	public void setMuscle(Muscle muscle) {
		this.muscle = muscle;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", exercise=" + exercise + ", weight=" + weight + ", goalReps=" + goalReps
				+ ", reps=" + reps + ", rpe=" + rpe + ", restTime=" + restTime + ", burnedCalo=" + burnedCalo
				+ ", muscle=" + muscle + "]";
	}

}
