package ftnbooking.rating.service;

import javax.jws.WebService;

import ftnbooking.rating.contracts.IRatingService;
import ftnbooking.rating.model.RatingData;

@WebService(endpointInterface = "ftnbooking.rating.contracts.IRatingService")
public class RatingService implements IRatingService{

	@Override
	public double CalculateRating(RatingData ratingData) {
		// TODO Auto-generated method stub
		double sumOfGrades = ratingData.getOldGrade() * ratingData.getNumberOfGrades();
        sumOfGrades += ratingData.getNewGrade();
        double retVal = sumOfGrades / (ratingData.getNumberOfGrades() + 1);
        return retVal;
	}

}
