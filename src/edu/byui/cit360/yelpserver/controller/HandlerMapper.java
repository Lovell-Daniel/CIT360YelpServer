package edu.byui.cit360.yelpserver.controller;

import java.util.HashMap;

public class HandlerMapper {
	private HashMap<String, Handler> handlerMap = new HashMap<>();

	public HandlerMapper() {
		//creates mapping for handler requests
		this.handlerMap.put("boot", new BootHandler());

	}

	public Handler getHandler(String request) {
		return this.handlerMap.get(request);
	}
}
