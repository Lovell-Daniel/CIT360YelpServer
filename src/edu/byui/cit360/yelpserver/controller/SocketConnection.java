package edu.byui.cit360.yelpserver.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnection implements Runnable {
	
	private final Socket clientConnection;
	private Controller controller;
	
	public SocketConnection(Controller controller, Socket clientConnection) {
		this.clientConnection = clientConnection;
		this.controller = controller;
	}
	
	public void run() {
		
		try (
			PrintWriter out = new PrintWriter(clientConnection.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
		) {		            
		    out.print("JSON?");
		    
		    
		    String line;
		    String json = "";
		    while ((line = in.readLine()) != null) {
		        if (line.length() == 0) break;
		    	out.println(line);
				controller.handleRequest(controller, "updateConsole", "json line: "+line);
				json = json + line;
		    }
		    controller.handleRequest(controller, "processJSON", json);
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
