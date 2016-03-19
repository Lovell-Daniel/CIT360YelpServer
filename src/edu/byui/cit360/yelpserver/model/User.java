package edu.byui.cit360.yelpserver.model;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;

public class User implements Serializable {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private LinkedBlockingQueue<YelpResponse> lastThree;

	public LinkedBlockingQueue<YelpResponse> getLastThree() {
		return lastThree;
	}

	public void setLastThree(LinkedBlockingQueue<YelpResponse> lastThree) {
		this.lastThree = lastThree;
	}
	
	public User() {
		
	}

	public User(String name, LinkedBlockingQueue<YelpResponse> lastThree) {
		this.name = name;
		this.lastThree = lastThree;
	}
	
}
