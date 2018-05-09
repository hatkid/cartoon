package com.comic.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("spring/application.xml")
@SpringBootApplication(scanBasePackages = "com.comic.www")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
