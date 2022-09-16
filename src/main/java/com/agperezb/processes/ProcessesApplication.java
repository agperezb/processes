package com.agperezb.processes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProcessesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessesApplication.class, args);
	}

	@GetMapping("/hola")
	public String Hola() {
		return "Hola";
	}

}
