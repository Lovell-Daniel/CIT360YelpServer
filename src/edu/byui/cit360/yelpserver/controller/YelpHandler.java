package edu.byui.cit360.yelpserver.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class YelpHandler extends Handler {

	Controller controller;
	
	@Override
	void handleIt(Controller controller, String... args) {
		this.controller = controller;
		String json;
		try {
			json = getYelp(urlBuilder(args[0],args[1]));
			saveSearch(json);
		} catch (IOException e) {
			String message = "\nThere was a problem getting the data from Yelp. ";
			controller.handleRequest(controller, "error", message + e.getMessage());
		}
		
	}
	
	private void saveSearch(String json) {

		try (Socket sock =  new Socket(InetAddress.getByName(null), 4499, null, 0);
		//try (Socket sock =  new Socket(InetAddress.getByName(null), 8080);
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
				) {
			out.print(json);
		} catch (IOException e) {
			String message = "\nThere was a problem saving to the server. ";
			controller.handleRequest(controller, "error", message + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private String urlBuilder(String term, String location) {
		
		StringBuilder url = new StringBuilder();
		url.append("http://pearedup.lovelllabs.com/yelp.php?term=");
		url.append(term);
		url.append("&location=");
		url.append(location);
		
		return url.toString();
	}
	
	private String getYelp(String query) throws IOException {
		
		URL url = new URL(query);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		String json = sb.toString();
		
		return json;
	
	}

}
