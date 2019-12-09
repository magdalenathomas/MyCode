package abstracts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import clients.Inmate;

public class FactoryInmates {

	public static ObjectOutputStream oos;
	//private static Socket socket;
	public static String topic = "lamp";
	// static Inmate inmate;

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			Inmate inmate = new Inmate();
			inmate.subscribe(topic);
			try {
				 Socket socket = new Socket("127.0.0.1", 5000);
				if (i == 5) {
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("stop");
				} else {
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("hi timer!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
