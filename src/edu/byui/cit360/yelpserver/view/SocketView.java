package edu.byui.cit360.yelpserver.view;

import java.net.ServerSocket;
import java.net.Socket;
import edu.byui.cit360.yelpserver.controller.Controller;

public class SocketView implements Runnable {	
	
	Controller controller;
	
	public SocketView(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		try {
			//while(controller.getModel().isKeepOpen()){
			while(true) {
				ServerSocket serverSocket = new ServerSocket(4499);
				Socket clientSocket = serverSocket.accept();
				//parse multiple connections in separate threads
				SocketConnectionView socketConnection = new SocketConnectionView(controller, clientSocket);
				new Thread(socketConnection).start();
			}
		} catch (Exception e) {
			String message = "\nThere was a problem starting the server. ";
			controller.handleRequest(controller, "error", message + e.getMessage());
			e.printStackTrace();
		}		
	}
}
