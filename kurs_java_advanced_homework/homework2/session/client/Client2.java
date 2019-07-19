package homework2.session.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client2 {
	public static void main(String[] args) {

		try {
			Socket s = new Socket("localhost", 8080);
			BufferedReader inc = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream outc = new PrintStream(s.getOutputStream());

			String sanswer = inc.readLine();
			if (sanswer.equals("Wprowadz działanie matematyczne: ")) {
				String odp = "2 + 3";
				outc.println(odp);
			} else if (sanswer.equals("Podaj liczbę i znak działania:")) {
				String odp = "3 +";
				outc.println(odp);
			} else
				System.out.println("ERROR");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
