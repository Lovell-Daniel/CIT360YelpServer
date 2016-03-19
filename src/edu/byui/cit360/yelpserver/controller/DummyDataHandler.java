package edu.byui.cit360.yelpserver.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import edu.byui.cit360.yelpserver.model.User;
import edu.byui.cit360.yelpserver.model.YelpResponse;

public class DummyDataHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		
		ZonedDateTime time1a = ZonedDateTime.now();
		ZonedDateTime time1b = ZonedDateTime.now();
		ZonedDateTime time1c = ZonedDateTime.now();
		ZonedDateTime time2a = ZonedDateTime.now();
		ZonedDateTime time2b = ZonedDateTime.now();
		ZonedDateTime time2c = ZonedDateTime.now();
		String sampleJSON = "{sample}";
		YelpResponse response1a = new YelpResponse(time1a, sampleJSON);
		YelpResponse response1b = new YelpResponse(time1b, sampleJSON);
		YelpResponse response1c = new YelpResponse(time1c, sampleJSON);
		YelpResponse response2a = new YelpResponse(time2a, sampleJSON);
		YelpResponse response2b = new YelpResponse(time2b, sampleJSON);
		YelpResponse response2c = new YelpResponse(time2c, sampleJSON);
		YelpResponse[] response1 = {response1a, response1b, response1c};
		YelpResponse[] response2 = {response2a, response2b, response2c};
		LinkedBlockingQueue<YelpResponse> lastThree1 = new LinkedBlockingQueue<>(3);
		LinkedBlockingQueue<YelpResponse> lastThree2 = new LinkedBlockingQueue<>(3);
		lastThree1 = populateQueue(lastThree1, response1);
		lastThree2 = populateQueue(lastThree2, response2);
		String user1 = "Daniel";
		String user2 = "Nicole";
		ArrayList<User> users = new ArrayList<>(2);
		users.add(new User(user1, lastThree1));
		users.add(new User(user2, lastThree2));
		controller.getModel().setUsers(users);
		
		
	}
	
	private LinkedBlockingQueue<YelpResponse> populateQueue(LinkedBlockingQueue<YelpResponse> lastThree,
			YelpResponse[] response) {
		try {
			for (int i = 0; i < response.length; i++) {
				if (lastThree.remainingCapacity() > 0) {
					lastThree.put(response[i]);
				} else {
					lastThree.take();
					lastThree.put(response[i]);
				};
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lastThree;
		
	}

}
