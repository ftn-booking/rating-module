package ftnbooking.rating.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "profanityWrapper")
public class ProfanitiesWrapper {

	@XmlElement(name="profanity")
	private ArrayList<String> profanities;
	
	
	
	
	public ProfanitiesWrapper() {
		// TODO Auto-generated constructor stub
		profanities = new ArrayList<String>();
	}

    
	
	public ProfanitiesWrapper(ArrayList<String> profanities) {
		super();
		this.profanities = profanities;
	}



	/*public ArrayList<String> retrieveProfs() {
		return profanities;
	}*/


	public void setProfanities(ArrayList<String> profanities) {
		this.profanities = profanities;
	}
	
	public String get(int i)
	{
		return profanities.get(i);
	}
	
	public int size()
	{
		return profanities.size();
	}
	public void add(String profanity)
	{
		profanities.add(profanity);
	}
	public void remove(int i)
	{
		profanities.remove(i);
	}
	public ArrayList<String> Profanities()
	{
		ArrayList<String> retVal = new ArrayList<>();
		for (String item : profanities) 
		{
			retVal.add(item);
		}
		return retVal;
	}
}
