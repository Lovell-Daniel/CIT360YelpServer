package edu.byui.cit360.yelpserver;

import edu.byui.cit360.yelpserver.controller.Controller;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		controller.handleRequest(controller, "boot");
		
	}

}
