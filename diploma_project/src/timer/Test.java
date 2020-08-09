package timer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Test {
	
	public static ObjectOutputStream oos;

	public static void start() {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("start");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stop() {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("stop");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		start();
		Thread.sleep(1000);
		stop();
		
	}

}
