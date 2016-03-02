package edu.byui.cit360.yelpserver.controller;

public class ProcessJSONHandler extends Handler {

	@Override
	void handleIt(Controller controller, String ... args) {
		//save latest JSON
		controller.getModel().getRecentSearches().setLastThree(args[0]);
		
		//process the JSON - not needed on server
		//JSONObject jsonObject = new JSONObject(args[0]);
		
		
		
	}

}
