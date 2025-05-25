package com.springboot_for_beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootForBeginnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootForBeginnerApplication.class, args);
	}

	@GetMapping("/greet")
	public String greeting() {
		return "Hello Valens";
	}

}
