package ftnbooking.rating.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingService")
public class CommentController {
	
	@RequestMapping(method = RequestMethod.POST, value="/profanity")
	public ResponseEntity<Boolean> addProfanity(@RequestBody String profanity) 
	{
		Boolean retVal = ProfanityManager.addProfanity(profanity);
		
		return new ResponseEntity<Boolean>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/profanity")
	public ResponseEntity<Boolean> removeProfanity(@RequestBody String profanity) 
	{
		Boolean retVal = ProfanityManager.removeProfanity(profanity);
		
		return new ResponseEntity<Boolean>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/profanity")
	public ResponseEntity<List<String>> getProfanities() 
	{
		ArrayList<String> retVal = new ArrayList<String>();
		
		retVal= ProfanityManager.getProfanities();
		
		
		return new ResponseEntity<List<String>>(retVal, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/comments")
	public ResponseEntity<Boolean> checkComment(@RequestBody String comment) 
	{
		Boolean retVal = false;
		for (String profanity : ProfanityManager.getProfanities()) 
		{
			if(comment.contains(profanity))
			{
				retVal = true;
				break;
			}
		}
		
		return new ResponseEntity<Boolean>(retVal, HttpStatus.OK);
	}

}
