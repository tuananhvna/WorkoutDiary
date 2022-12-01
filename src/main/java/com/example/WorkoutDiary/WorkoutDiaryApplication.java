package com.example.WorkoutDiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.WorkoutDiary.domain.Muscle;
import com.example.WorkoutDiary.domain.MuscleRepository;
import com.example.WorkoutDiary.domain.UserRepository;
import com.example.WorkoutDiary.domain.Users;
import com.example.WorkoutDiary.domain.Workout;
import com.example.WorkoutDiary.domain.WorkoutRepository;

@SpringBootApplication
public class WorkoutDiaryApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WorkoutDiaryApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WorkoutDiaryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner workoutDemo(WorkoutRepository wRepository, MuscleRepository mRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("save some workouts");
			//create muscle sample
			Muscle muscle1 = new Muscle("Chest");
			Muscle muscle2 = new Muscle("Back");
			Muscle muscle3 = new Muscle("Leg");

			mRepository.save(muscle1);
			mRepository.save(muscle2);
			mRepository.save(muscle3);
			
			//create workout sample
			wRepository.save(new Workout("Bench press", 60, 12, 12, 8, 60, 0, muscle1));
			wRepository.save(new Workout("Deadlift", 100, 8, 8, 8, 60, 0, muscle2));
			wRepository.save(new Workout("Squat", 120, 6,6, 8, 60, 0, muscle2));

			//create users: client/user coach/admin
			Users user1 = new Users("client", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "CLIENT");
			Users user2 = new Users("coach", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "COACH");
			uRepository.save(user1);
			uRepository.save(user2);

			log.info("fetch all workouts");
			for (Workout workout : wRepository.findAll()) {
				log.info(workout.toString());
			}
		};
	}

}
