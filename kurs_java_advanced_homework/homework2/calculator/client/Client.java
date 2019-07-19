package homework2.calculator.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost", 8080);
			BufferedReader inc = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream outc = new PrintStream(s.getOutputStream());

			String sanswer = inc.readLine();
				String odp = "2 + 2";
				outc.println(odp);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}