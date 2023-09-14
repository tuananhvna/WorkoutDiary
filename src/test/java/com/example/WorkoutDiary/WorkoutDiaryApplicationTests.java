package com.example.WorkoutDiary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WorkoutDiary.web.WorkoutController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WorkoutDiaryApplicationTests {

	@Autowired
    private WorkoutController controller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
