package com.example.WorkoutDiary.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.WorkoutDiary.domain.MuscleRepository;
import com.example.WorkoutDiary.domain.Workout;
import com.example.WorkoutDiary.domain.WorkoutRepository;

@Controller
public class WorkoutController {
	@Autowired
	private WorkoutRepository wRepository;
	
	@Autowired
	private MuscleRepository mRepository;
	
	//show all workouts
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	//show all workouts
	@RequestMapping(value={"/", "/workoutlist"})
	public String listWorkout(Model model) {
		model.addAttribute("workouts", wRepository.findAll());
		return "workoutlist";
	}
	
	//add a workout
	@RequestMapping("/add")
	public String addWorkout(Model model) {
		model.addAttribute("workout", new Workout());
		model.addAttribute("muscles", mRepository.findAll());
		return "addworkout";
	}
	
	
	//save a workout
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Workout workout){
		wRepository.save(workout);
        return "redirect:workoutlist";
    }
	
	
	//delete a workout
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
		wRepository.deleteById(workoutId);
        return "redirect:../workoutlist";
    }
	
	
	//edit a workout
	@RequestMapping(value = "edit/{id}")
	public String showModWorkout(@PathVariable("id") Long workoutId, Model model) {
		model.addAttribute("workout", wRepository.findById(workoutId));
		model.addAttribute("muscles", mRepository.findAll());
		return "editworkout";
	}
	
	//RESTful service to list all workouts
	@GetMapping(value = "/workouts")
	public @ResponseBody List<Workout> workoutListRest() {
		return (List<Workout>) wRepository.findAll();
	}
	
	//RESTful service to find a workout by id
	@GetMapping(value = "/workout/{id}")
	public @ResponseBody Optional<Workout> findWorkoutRest(@PathVariable("id") Long id) {
		return wRepository.findById(id);
	}
}
