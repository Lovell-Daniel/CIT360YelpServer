package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.model.User;
import edu.byui.cit360.yelpserver.model.YelpResponse;
import edu.byui.cit360.yelpserver.view.ModelView;

public class PrintModelHandler extends Handler {

	@Override
	void handleIt(Controller controller, String... args) {
		
		//create array of users from ArrayList
		User[] users = new User[controller.getModel().getUsers().size()];
		users = controller.getModel().getUsers().toArray(users);
		
		//create 2d array of responses from LinkedBlockingQueue
		YelpResponse[][] responses = new YelpResponse[controller.getModel().getUsers().size()][];
		responses[0] = new YelpResponse[controller.getModel().getUsers().get(0).getLastThree().size()];
		responses[0] = controller.getModel().getUsers().get(0).getLastThree().toArray(responses[0]);
		responses[1] = new YelpResponse[controller.getModel().getUsers().get(1).getLastThree().size()];
		responses[1] = controller.getModel().getUsers().get(0).getLastThree().toArray(responses[1]);

		//Build string to display
		StringBuilder sb = new StringBuilder();
		sb.append("\n"+users[0].getName());
		sb.append("\n"+responses[0][0].getTime().toString());
		sb.append("\n"+responses[0][0].getJson());
		sb.append("\n"+responses[0][1].getTime().toString());
		sb.append("\n"+responses[0][1].getJson());
		sb.append("\n"+responses[0][2].getTime().toString());
		sb.append("\n"+responses[0][2].getJson());
		sb.append("\n"+users[1].getName());
		sb.append("\n"+responses[1][0].getTime().toString());
		sb.append("\n"+responses[1][0].getJson());
		sb.append("\n"+responses[1][1].getTime().toString());
		sb.append("\n"+responses[1][1].getJson());
		sb.append("\n"+responses[1][2].getTime().toString());
		sb.append("\n"+responses[1][2].getJson());
		sb.append("\n");
		
		ModelView modelView = new ModelView(controller, sb.toString());
		modelView.display();
	
	}

}
