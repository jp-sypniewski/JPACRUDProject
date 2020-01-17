package com.skilldistillery.bootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.JPACrudProject")
public class BootMvcLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcLibraryApplication.class, args);
	}

}
