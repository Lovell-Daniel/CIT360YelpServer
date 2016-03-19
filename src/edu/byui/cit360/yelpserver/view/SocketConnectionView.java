package edu.byui.cit360.yelpserver.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import edu.byui.cit360.yelpserver.controller.Controller;

public class SocketConnectionView implements Runnable {
	
	private final Socket clientConnection;
	private Controller controller;
	
	public SocketConnectionView(Controller controller, Socket clientConnection) {
		this.clientConnection = clientConnection;
		this.controller = controller;
	}
	
	public void run() {
		
		try (
			PrintWriter out = new PrintWriter(clientConnection.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
		) {		            
		    //out.print("JSON?");
		    
		    String line;
		    StringBuilder sb = new StringBuilder();
		    while ((line = in.readLine()) != null) {
				sb.append(line);
		    }
		    controller.handleRequest(controller, "processJSON", sb.toString());
		} catch (Exception e) {
			String message = "\nThere was a problem establishing a connection with a client.  ";
			controller.handleRequest(controller, "error", message + e.getMessage());
			e.printStackTrace();
	    }
	}
}
