package edu.byui.cit360.yelpserver.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class YelpResponse implements Serializable{

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	private ZonedDateTime time;
	private String json;
	
	public YelpResponse() {
	}
	
	public YelpResponse(ZonedDateTime time, String json) {
		this.json = json;
		this.time = time;
	}
	
}
