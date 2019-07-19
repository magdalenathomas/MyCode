package homework1.joke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try (ServerSocket ss = new ServerSocket(8080);) {
			System.out.println("Server started, i'm waiting for a client...");
			Socket s = ss.accept();
			System.out.println("Client accepted");

			BufferedReader ins = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream outs = new PrintStream(s.getOutputStream());

			String inputc = ins.readLine();
			System.out.println("Klient wysłał: " + inputc);

			if (inputc.equals("Puk puk")) {
				String odp = "Kto tam?";
				outs.println(odp);
				System.out.println("Serwer: " + odp);
			} else {
				System.out.println("Nie znam takiego żądania");
			}

			String inputclient = ins.readLine();
			System.out.println("Klient wysłał: " + inputclient);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
