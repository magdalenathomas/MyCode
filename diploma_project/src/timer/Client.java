package timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class Client {

	protected static Socket socket;
	protected static ObjectOutputStream oos;
	protected static ObjectInputStream ois;

	public Client(String address, int port) {

		try {
			socket = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void input() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Message: " + message);
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public abstract void output();
}
