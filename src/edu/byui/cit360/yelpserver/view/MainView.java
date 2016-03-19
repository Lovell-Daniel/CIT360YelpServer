package edu.byui.cit360.yelpserver.view;

import edu.byui.cit360.yelpserver.controller.Controller;

public class MainView extends View {

	public MainView(Controller controller) {
		super(controller, "Main Menu\nS=Start Server, H=Help, E=Exit Program");
	}

	@Override
	public boolean doAction(char choice) {

        switch (choice) {
            case 'S': 
                controller.handleRequest(controller, "start");
                break;
            case 'H': 
            	controller.handleRequest(controller, "help");
            	break;
            case 'E': 
            	break;
            default: // 
                console.println("\n*** Invalid selection - Try again ***");
                break;
        }
        return true;
	}
}
