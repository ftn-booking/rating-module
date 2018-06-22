package ftnbooking.rating.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftnbooking.rating.model.RatingData;

@RestController
@RequestMapping("/ratingService/rating")
public class RatingController {

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Double> rating(@RequestBody RatingData ratingData) 
	{
		
		
		try
		{
			double sumOfGrades = ratingData.getOldGrade() * ratingData.getNumberOfGrades();
	        sumOfGrades += ratingData.getNewGrade();
	        double retVal = sumOfGrades / (ratingData.getNumberOfGrades() + 1);
	        return new ResponseEntity<>(retVal, HttpStatus.OK);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
