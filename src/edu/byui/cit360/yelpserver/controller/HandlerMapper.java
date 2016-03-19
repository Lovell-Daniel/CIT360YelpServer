package edu.byui.cit360.yelpserver.controller;

import java.util.concurrent.ConcurrentHashMap;

public class HandlerMapper {
	
	private ConcurrentHashMap<String, Handler> handlerMap = new ConcurrentHashMap<>();

	public HandlerMapper() {
		//creates mapping for handler requests
		handlerMap.put("boot", new BootHandler());
		handlerMap.put("error", new ErrorHandler());
		handlerMap.put("start", new SocketHandler());
		handlerMap.put("dummyData", new DummyDataHandler());
		handlerMap.put("stop", new CloseSocketHandler());
		handlerMap.put("client", new ClientHandler());
		handlerMap.put("yelp", new YelpHandler());
		handlerMap.put("processJSON", new ProcessJSONHandler());
		handlerMap.put("model", new PrintModelHandler());


	}

	public Handler getHandler(String request) {
		
		return handlerMap.get(request);
	
	}
}
