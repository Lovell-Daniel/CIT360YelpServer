package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.view.ErrorView;

public class ErrorHandler extends Handler {

	@Override
	void handleIt(Controller controller, String ... args) {
		
		ErrorView errorView = new ErrorView(controller, args[0]);
		errorView.display();
		
	}

}
