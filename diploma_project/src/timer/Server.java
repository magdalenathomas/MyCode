package timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private Socket socket; // socket do komunikacji z klientem
	private ServerSocket server; // socket do nasluchiwania

	public static long start;
	public static long stop;
	public static long time;

	public Server(int port) throws ClassNotFoundException {

		try {
			// tworzenie socketa do nasluchiwania
			server = new ServerSocket(port);
			System.out.println("Server started!");
			for (int i = 0; i < 2; i++) {
				System.out.println("Waiting for a client...");

				// polaczenie z klientem
				socket = server.accept();
				System.out.println("Client accepted!");

				// read from socket to ObjectInputStream object
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				// convert ObjectInputStream object to String
				String message = (String) ois.readObject();
				System.out.println("Message Received: " + message);
				if (message.equalsIgnoreCase("start")) {
					start = System.currentTimeMillis();
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("Uruchamiam zegar " + start);
					oos.close();
				} else if (message.equalsIgnoreCase("stop")) {
					stop = System.currentTimeMillis();
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("Zatrzymuje zegar " + stop);
					oos.close();
				} else {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("Nie rozpoznano komedy");
					oos.close();
				}

				// close resources
				ois.close();
				socket.close();
				// terminate the server if client sends exit request
				if (message.equalsIgnoreCase("exit"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		Server server = new Server(5000);

	System.out.println("Czas odpowiedzi wynosi: " + (stop - start) + " ms");
	}
}
