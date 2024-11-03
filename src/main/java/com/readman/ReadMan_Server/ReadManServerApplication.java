package com.readman.ReadMan_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ReadManServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReadManServerApplication.class, args);
	}
}
