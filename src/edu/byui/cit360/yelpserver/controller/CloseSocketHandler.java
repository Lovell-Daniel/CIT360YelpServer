package edu.byui.cit360.yelpserver.controller;

public class CloseSocketHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		controller.getModel().setKeepOpen(false);
		controller.getConsole().println("Ready to close server.");
	}

}
