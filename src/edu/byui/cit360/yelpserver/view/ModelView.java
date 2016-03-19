package edu.byui.cit360.yelpserver.view;

import edu.byui.cit360.yelpserver.controller.Controller;

public class ModelView extends View {

	public ModelView(Controller controller, String message) {
		super(controller, message);
	}
	
	@Override
	public boolean doAction(char choice) {
		
		switch (choice) {
        case 'E': 
        	break;
        default: // 
            console.println("\n*** Invalid selection - Try again ***");
            break;
	    }
	    return true;
    }

}
