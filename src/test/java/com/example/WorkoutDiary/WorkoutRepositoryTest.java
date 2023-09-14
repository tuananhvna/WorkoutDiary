package com.example.WorkoutDiary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WorkoutDiary.domain.Muscle;
import com.example.WorkoutDiary.domain.Workout;
import com.example.WorkoutDiary.domain.WorkoutRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class WorkoutRepositoryTest {
	
	@Autowired
    private WorkoutRepository repository;
	
	@Test
    public void findByExerciseShouldReturnMuscleName() {
        List<Workout> workouts = repository.findByExercise("Bench press");
        
        assertThat(workouts).hasSize(1);
        assertThat(workouts.get(0).getMuscle().getName()).isEqualTo("Chest");
    }
	
	@Test
    public void createNewWorkout() {
    	Workout workout = new Workout("Shoulder press", 50, 6, 3, 5, 120, 0, new Muscle("Shoulder"));
    	repository.save(workout);
    	assertThat(workout.getId()).isNotNull();
    }
	
	@Test
    public void deleteNewWorkout() {
		List<Workout> workouts = repository.findByExercise("Deadlift");
		Workout workout = workouts.get(0);
		repository.delete(workout);
		List<Workout> newWorkouts = repository.findByExercise("Deadlift");
		assertThat(newWorkouts).hasSize(0);
     }

	
}
