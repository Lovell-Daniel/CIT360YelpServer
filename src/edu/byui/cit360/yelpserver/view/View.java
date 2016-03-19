package edu.byui.cit360.yelpserver.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import edu.byui.cit360.yelpserver.controller.Controller;

public abstract class View implements ViewInterface {
	
	protected String promptMessage;
	protected final BufferedReader keyboard;
	protected final PrintWriter console;
	protected Controller controller;
	
	public View(Controller controller, String promptMessage) {
		this.controller = controller;
		this.keyboard = controller.getKeyboard();
		this.console = controller.getConsole();
		this.promptMessage = promptMessage;
	}

	@Override
	public void display() {
        char value;
        
        do {
            console.println(this.promptMessage);
            value = getInput();
            doAction(value);
        } while (value != 'E');
	}

	@Override
	public char getInput() {
        String selection = null;
        Boolean repeat = true;
        while (repeat) {
            try {
				console.print("\nEnter your selection: ");
				selection = keyboard.readLine();
         
				selection = selection.trim().toUpperCase();
				
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
        
        char choice = selection.charAt(0);
        return choice;
	}


	
	
	
}
