package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.view.ClientView;

public class ClientHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		ClientView clientView = new ClientView(controller);
		clientView.display();
	}

}
