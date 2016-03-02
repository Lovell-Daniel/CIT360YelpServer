package edu.byui.cit360.yelpserver.view;

import java.net.ServerSocket;
import java.net.Socket;

import edu.byui.cit360.yelpserver.controller.Controller;
import edu.byui.cit360.yelpserver.controller.SocketConnection;

public class SocketView implements Runnable {
	
	Controller controller;
	
	public SocketView(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		try {
			while(true){
				ServerSocket serverSocket = new ServerSocket(8080);
				Socket clientSocket = serverSocket.accept();
				//parse multiple connections in separate threads
				SocketConnection socketConnection = new SocketConnection(controller, clientSocket);
				new Thread(socketConnection).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}		
	}
}
