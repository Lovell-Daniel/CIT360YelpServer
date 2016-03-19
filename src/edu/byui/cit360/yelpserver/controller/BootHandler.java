package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.view.MainView;

public class BootHandler extends Handler {

	@Override
	public void handleIt(Controller controller, String... args) {
		
		//Load dummy data
		controller.handleRequest(controller, "dummyData");
		controller.getModel().setKeepOpen(true);
		
		//Load MainView
		MainView mainView = new MainView(controller);
		mainView.display();
		
	}

}
