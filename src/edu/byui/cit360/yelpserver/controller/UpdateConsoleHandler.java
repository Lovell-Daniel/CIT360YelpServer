package edu.byui.cit360.yelpserver.controller;

public class UpdateConsoleHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {

		System.out.println(args[0]);
		
	}

}
