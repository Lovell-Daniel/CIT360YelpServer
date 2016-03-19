package edu.byui.cit360.yelpserver.view;

import edu.byui.cit360.yelpserver.controller.Controller;

public class RunningView extends View {

	public RunningView(Controller controller) {
		super(controller, "Running Menu\nS=Stop Server, C=Open Client, M=Model, H=Help, E=Exit Program");
	}

	
	@Override
	public boolean doAction(char choice) {

        switch (choice) {
            case 'S': 
                controller.handleRequest(controller, "stop");
                break;
            case 'C': 
                controller.handleRequest(controller, "client");
                break;
            case 'M': 
                controller.handleRequest(controller, "model");
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
