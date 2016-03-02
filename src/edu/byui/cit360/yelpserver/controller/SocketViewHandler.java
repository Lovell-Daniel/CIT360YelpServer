package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.view.SocketView;

public class SocketViewHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		SocketView socketView = new SocketView(controller);
		new Thread(socketView).start();
	}

}
