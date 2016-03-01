package edu.byui.cit360.yelpserver.controller;

import edu.byui.cit360.yelpserver.model.Model;
import edu.byui.cit360.yelpserver.view.View;

public class Controller {

	private Model model;
	private View view;
	private HandlerMapper handlerMapper;

	public Controller(Model model, View view) {
		
		//initializes the model, view, and handerMapper
		this.model = model;
		this.view = view;
		handlerMapper = new HandlerMapper();
		
	}
	

	public Model getModel() {
		return model;
	}
	
	public View getView() {
		return view;
	}
	
	public void handleRequest(String request, String ... args) {
		
		Handler handler = this.handlerMapper.getHandler(request);
		handler.handleIt(args);
		
	}
	
}
