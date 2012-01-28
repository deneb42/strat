/*
 * Server-side client class
 */

import java.io.*;
import java.net.*;

public class AndroClient {
	// Internal objects
	private int iD;
	private Socket socket;
	private ClientThread thread;

	// Client methods
	public AndroClient(int iD, Socket socket) {
		// Store client attributes
		this.iD = iD;
		this.socket = socket;
		// Create an input stream
		InputStream stream;
		try {
			stream = socket.getInputStream();
		} catch (IOException io) {
			return;
		}
		// Start the listening thread
		thread = new ClientThread(stream);
		thread.start();
	}

	public int getiD() {
		return iD;
	}

	// Internal client thread
	private class ClientThread extends Thread {
		// Internal objects
		private InputStream stream;

		// ClientThread methods
		public ClientThread(InputStream stream) {
			super();
			this.stream = stream;
		}

		public void run() {
			int len = 0;
			byte temp[] = new byte[21];
			while (true){
				// Retrieve a message
				try {
					// Get the message
					len = stream.read(temp, 0, temp.length);
					if (len < 0) break;
					// Print the message received
					String txt = new String(temp, 0, len);
					System.out.println("Client : sent " + txt);
				} catch (Exception ex) {
					System.out.println("Client : listening exception "
							+ ex.getLocalizedMessage());
				}
			}
		}
	}
};
