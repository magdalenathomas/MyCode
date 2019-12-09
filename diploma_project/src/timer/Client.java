package timer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public interface Client {

	//public static Socket socket;
	//public static ObjectOutputStream oos;
	//public static ObjectInputStream ois;

	/*public Client(String address, int port) {

		try {
			Socket socket = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	public void input(); 

	public void output();
}
