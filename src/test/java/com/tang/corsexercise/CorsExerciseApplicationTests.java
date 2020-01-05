package com.tang.corsexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CorsExerciseApplicationTests {

	private CorsExerciseApplication application;

	@BeforeEach
	void setUp() {
		application = new CorsExerciseApplication();
	}

	@Test
	void contextLoads() {
		assertThat(application).isNotNull();
	}

}
