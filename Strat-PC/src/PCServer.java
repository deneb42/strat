/*
 * Main server class
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PCServer {
	// Global constants
	private static final int SERVER_PORT = 50000;
	private static final int MAX_CLIENTS = 6;

	// Internal objects
	private ServerSocket serverSocket;
	private List<AndroClient> clients; 
	
	// Main program
	public static void main(String[] args) {
		PCServer server = new PCServer();
		server.run();
	}

	// Server methods
	public PCServer()	{
		clients = new ArrayList<AndroClient>();
	}
	
	public void run() {
	// Open the server listener socket
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException ex) {
			System.out.println("Server : unable to open listener socket " + ex.getLocalizedMessage());
			return;
		}
		System.out.println("Server : opened on port = " + SERVER_PORT);
	// Listen to client connections
		for (int i = 0; i < MAX_CLIENTS; i ++) {
		// Create a new client
			Socket socket;
			try {	
				socket = serverSocket.accept();
			} catch (Exception ex) {
				System.out.println("Server : general exception " + ex.getLocalizedMessage());
				break;
			}
			AndroClient client = new AndroClient(i, socket);
		// Register in the list
			clients.add(client);
			System.out.println("Server : adding client iD = " + i);
		}
	}
}
