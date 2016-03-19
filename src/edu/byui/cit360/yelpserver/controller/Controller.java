package edu.byui.cit360.yelpserver.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import edu.byui.cit360.yelpserver.model.Model;

public class Controller {

	private Model model;
	private HandlerMapper handlerMapper;
    private BufferedReader keyboard;
    private PrintWriter console;

	public Controller() {
		
		setModel(new Model());
		//populates model with dummy data
		handlerMapper = new HandlerMapper();
		setKeyboard(new BufferedReader(new InputStreamReader(System.in)));
		setConsole(new PrintWriter(System.out, true));
		
	}
	
	public void handleRequest(Controller controller, String request, String ... args) {
		
		Handler handler = handlerMapper.getHandler(request);
		handler.handleIt(controller, args);
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public BufferedReader getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(BufferedReader keyboard) {
		this.keyboard = keyboard;
	}

	public PrintWriter getConsole() {
		return console;
	}

	public void setConsole(PrintWriter console) {
		this.console = console;
	}
	
}
