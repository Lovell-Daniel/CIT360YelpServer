package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.view.RunningView;
import edu.byui.cit360.yelpserver.view.SocketView;

public class SocketHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		SocketView socketView = new SocketView(controller);
		new Thread(socketView).start();
		RunningView runningView = new RunningView(controller);
		runningView.display();
	}

}
