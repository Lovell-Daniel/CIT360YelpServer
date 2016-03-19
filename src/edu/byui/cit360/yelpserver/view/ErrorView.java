package edu.byui.cit360.yelpserver.view;

import edu.byui.cit360.yelpserver.controller.Controller;

public class ErrorView extends View {

	public ErrorView(Controller controller, String errorMessage) {
		super(controller, "***Error***\n"+errorMessage+"\nEnter E to exit to previous menu");
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
