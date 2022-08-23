package com.cos.photogramstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PhotogramStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotogramStartApplication.class, args);
	}

}
