package edu.byui.cit360.yelpserver.controller;

public class BootHandler extends Handler {

	@Override
	public void handleIt(Controller controller, String... args) {
		
		//update console
		controller.handleRequest(controller, "updateConsole", "Booting ...");
		
		//load from persistence
		controller.handleRequest(controller, "loadFromPersist");
		
		//open socket view
		controller.handleRequest(controller, "socketView");
		
		//open keyboard input
		controller.handleRequest(controller, "keyboardListener");
		
	}

}
