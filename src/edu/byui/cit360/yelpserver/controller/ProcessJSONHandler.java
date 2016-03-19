package edu.byui.cit360.yelpserver.controller;

import java.time.ZonedDateTime;
import java.util.concurrent.LinkedBlockingQueue;

import edu.byui.cit360.yelpserver.model.YelpResponse;

public class ProcessJSONHandler extends Handler {

	@Override
	public void handleIt(Controller controller, String... args) {

		ZonedDateTime now = ZonedDateTime.now();
		YelpResponse yelpResponse = new YelpResponse(now, args[0]);
		LinkedBlockingQueue<YelpResponse> lastThree = controller.getModel().getUsers().get(0).getLastThree();
		try {
			lastThree.take();
			lastThree.put(yelpResponse);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
