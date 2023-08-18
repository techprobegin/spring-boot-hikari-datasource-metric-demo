package com.techprobegin.hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HikariDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(HikariDemoApplication.class, args);
	}
}
