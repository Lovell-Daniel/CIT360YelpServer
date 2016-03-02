package edu.byui.cit360.yelpserver.controller;

import java.util.HashMap;

public class HandlerMapper {
	private HashMap<String, Handler> handlerMap = new HashMap<>();

	public HandlerMapper() {
		//creates mapping for handler requests
		handlerMap.put("boot", new BootHandler());
		handlerMap.put("updateConsole", new UpdateConsoleHandler());
		handlerMap.put("keyboardListener", new KeyboardListenerHandler());
		handlerMap.put("socketView", new SocketViewHandler());
		handlerMap.put("processJSON", new ProcessJSONHandler());
		handlerMap.put("loadFromPersist", new LoadFromPersistHandler());


	}

	public Handler getHandler(String request) {
		return this.handlerMap.get(request);
	}
}
