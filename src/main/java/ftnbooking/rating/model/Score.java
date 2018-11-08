package ftnbooking.rating.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "score")
public class Score {

	@XmlElement(name="points")
	private long points;
	@XmlElement(name="name")
	private String username;
	@XmlElement(name="time")
	private long time;
	public Score() {
		
		
	}
	public Score(long points, String username, long time) {
		super();
		this.points = points;
		this.username = username;
		this.time = time;
	}
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
