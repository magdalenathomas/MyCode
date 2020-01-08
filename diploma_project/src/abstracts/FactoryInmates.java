package abstracts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import clients.Inmate;

public class FactoryInmates {
	
	public static ObjectOutputStream oos;
	public static String topic = "lamp";

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			Inmate inmate = new Inmate(i);
			inmate.subscribe(topic);
			
			//used when QoS=0
			try {
				if (i == 1000) {
					Socket socket = new Socket("127.0.0.1", 5000);
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject("stop");
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
