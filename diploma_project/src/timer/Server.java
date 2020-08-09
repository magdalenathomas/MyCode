package timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private Socket socket; // socket for communication with client
	private ServerSocket server; // listening socket
	public static long start;
	public static long stop;
	public static int counter = 0;

	public Server(int port) throws ClassNotFoundException {

		try {
			server = new ServerSocket(port); // creating listening socket
			System.out.println("Server started!");

			while (true) {
				System.out.println("Waiting for a client...");

				socket = server.accept(); // connecting with client
				System.out.println("Client accepted!");

				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); // read from socket to
																						// ObjectInputStream object
				String message = (String) ois.readObject(); // convert ObjectInputStream object to String
				System.out.println("Message Received: " + message);

				if (message.equalsIgnoreCase("start")) {
					start = System.currentTimeMillis();
				}
				
				if (message.equalsIgnoreCase("hi server!")) {
					count();
					if (counter == 1000) {
						stop = System.currentTimeMillis();
						break;
					}
				}

				if (message.equalsIgnoreCase("stop")) {
					stop = System.currentTimeMillis();
					break;
				}

				ois.close(); // closing ObjectInputStream
				socket.close(); // closing socket for communication with client
			}
			server.close(); // closing listening socket

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int count() {
		return counter++;
	}

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		new Server(5000);

		System.out.println("Response time: " + (stop - start) + " ms");
	}
}
