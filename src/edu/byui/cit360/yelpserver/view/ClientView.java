package edu.byui.cit360.yelpserver.view;

import java.io.IOException;

import edu.byui.cit360.yelpserver.controller.Controller;

public class ClientView extends View {

	private String q1 = "\nSearch Term:";
	private String q2 = "\nZip Code:";
	private String term;
	private String location;
	
	public ClientView(Controller controller) {
		super(controller, "Yelp Search");
	}
	
	@Override
	public void display() {
            console.println(promptMessage);
            console.println(q1);
            term = getString();
            console.println(q2);
            location = getString();
            doAction('Y');
	}

	public String getString() {
        String selection = null;
        Boolean repeat = true;
        while (repeat) {
            try {
				selection = keyboard.readLine();
         
				selection = selection.trim().toLowerCase();
				
				if(selection.length() < 1){
				    repeat = true;
				} else {
					repeat = false;
				}
			} catch (IOException e) {
				String message = "\nThere was a problem getting your input. ";
				controller.handleRequest(controller, "error", message + e.getMessage());
			}
        }
        
        return selection;
	}

	@Override
	public boolean doAction(char choice) {

        switch (choice) {
            case 'Y': 
                controller.handleRequest(controller, "yelp", term, location);
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
