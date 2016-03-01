package edu.byui.cit360.yelpserver;

import edu.byui.cit360.yelpserver.controller.Controller;
import edu.byui.cit360.yelpserver.model.Model;
import edu.byui.cit360.yelpserver.view.View;

public class Main {

	public static void main(String[] args) {
		
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);
		
		controller.handleRequest("boot");
	}

}
