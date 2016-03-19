package edu.byui.cit360.yelpserver.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {
	
	private ArrayList<User> users;
	private boolean keepOpen;
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public Model() {
		
	}
	
	public Model(ArrayList<User> users) {
		this.users = users;
	}

	public boolean isKeepOpen() {
		return keepOpen;
	}

	public void setKeepOpen(boolean keepOpen) {
		this.keepOpen = keepOpen;
	}
}