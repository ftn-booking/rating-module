package ftnbooking.rating.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ftnbooking.rating.model.ProfanitiesWrapper;

public class ProfanityManager {

	
	private static ProfanitiesWrapper profanities = new ProfanitiesWrapper();
	
	public ProfanityManager()
	{
		loadProfanities();
	}
	
	
	
	private void loadProfanities() {
		// TODO Auto-generated method stub
		try
		{
			JAXBContext context = JAXBContext.newInstance(ProfanitiesWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			profanities = (ProfanitiesWrapper) unmarshaller.unmarshal(new File("././././profanities.xml"));
		}catch(Exception ex)
		{
			profanities = new ProfanitiesWrapper();
			System.out.println("Could not load profanities.");
		}
	}

	private static void saveProfanities() {
		// TODO Auto-generated method stub
		try
		{
			JAXBContext context = JAXBContext.newInstance(ProfanitiesWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(profanities, new FileOutputStream(new File("././././profanities.xml")));
		}catch(Exception ex)
		{
			System.out.println("Could not save profanities.");
			ex.toString();
		}
		
		
	}
	
	


	public static Boolean addProfanity(String profanity)
	{
		Boolean retVal = true;
		for (int i = 0; i < profanities.size(); i++) 
		{
			if(profanities.get(i).equals(profanity))
			{
				retVal=false;
				break;
			}
		}
		if(retVal)
		{
			profanities.add(profanity);
			saveProfanities();
		}
		return retVal;
	}
	
	
	



	public static Boolean removeProfanity(String profanity)
	{
		Boolean retVal = false;
		for (int i = 0; i < profanities.size(); i++) 
		{
			if(profanities.get(i).equals(profanity))
			{
				profanities.remove(i);
				retVal=true;
				break;
			}
		}
		if(retVal)
		{
			saveProfanities();
		}
		return retVal;
	}
	
	public static ArrayList<String> getProfanities()
	{
		
		return profanities.Profanities();
	}
	
	
}
