package ftnbooking.rating.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "scoreWrapper")
public class ScoreWrapper {
	@XmlElement(name="score")
	private ArrayList<Score> scores;
	
	
	public ScoreWrapper() {
		// TODO Auto-generated constructor stub
		scores = new ArrayList<Score>();
		Score temp1 = new Score(2000, "proba", 10);
		Score temp2 = new Score(3000, "proba", 110);
		Score temp3 = new Score(2000, "proba", 9);
		scores.add(temp1);
		scores.add(temp2);
		scores.add(temp3);
	}

	public void add(Score score)
	{
		scores.add(score);
	}

	public ArrayList<Score> scores()
	{
		ArrayList<Score> retVal = new ArrayList<>();
		for (Score item : scores) 
		{
			retVal.add(item);
		}
		
		for (int i = 0; i < retVal.size(); i++) 
		{
			for (int j = i+1; j < retVal.size(); j++) 
			{
				if(retVal.get(j).getPoints()>retVal.get(i).getPoints() || (retVal.get(j).getPoints()==retVal.get(i).getPoints() && retVal.get(j).getTime()<retVal.get(i).getTime()))
				{
					Score temp = retVal.get(j);
					retVal.set(j, retVal.get(i));
					retVal.set(i,temp);
				}
			}
		}
		
		
		return retVal;
	}

}
