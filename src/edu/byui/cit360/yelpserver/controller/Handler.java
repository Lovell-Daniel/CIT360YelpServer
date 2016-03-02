package edu.byui.cit360.yelpserver.controller;

public abstract class Handler {
	abstract void handleIt(Controller controller, String ... args);
}
