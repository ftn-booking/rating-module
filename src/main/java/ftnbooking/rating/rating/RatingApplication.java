package ftnbooking.rating.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import ftnbooking.rating.service.ProfanityManager;
import ftnbooking.rating.service.RatingController;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackageClasses = RatingController.class)
public class RatingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RatingApplication.class, args);
	}
}
