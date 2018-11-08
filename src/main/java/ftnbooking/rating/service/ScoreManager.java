package ftnbooking.rating.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ftnbooking.rating.model.Score;
import ftnbooking.rating.model.ScoreWrapper;

public class ScoreManager {

	private static ScoreWrapper scores = new ScoreWrapper();
	
	public ScoreManager()
	{
		loadScores();
	}
	
	private void loadScores() {
		// TODO Auto-generated method stub
		try
		{
			JAXBContext context = JAXBContext.newInstance(ScoreWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			scores = (ScoreWrapper) unmarshaller.unmarshal(new File("././././scores.xml"));
		}catch(Exception ex)
		{
			scores = new ScoreWrapper();
			System.out.println("Could not load profanities.");
		}
	}
	private static void saveScores() {
		// TODO Auto-generated method stub
		try
		{
			JAXBContext context = JAXBContext.newInstance(ScoreWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(scores, new FileOutputStream(new File("././././scores.xml")));
		}catch(Exception ex)
		{
			System.out.println("Could not save profanities.");
			ex.toString();
		}
		
		
	}
	
	public static void addScore(Score score) 
	{
		scores.add(score);
		saveScores();
	}
	public static ArrayList<Score> getScores()
	{
		
		return scores.scores();
	}
}
