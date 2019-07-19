package homework2.session.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import homework2.calculator.server.Action;
import homework2.calculator.server.OperationFactory;

public class Server {

	static Map<String, Double> mapa = new HashMap<String, Double>();

	public static void main(String[] args) {

		while (true) {
			try (ServerSocket ss = new ServerSocket(8080);) {
				System.out.println("Server started, i'm waiting for a client...");
				Socket s = ss.accept();
				System.out.println("Client accepted");

				BufferedReader ins = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintStream outs = new PrintStream(s.getOutputStream());
				String klucz = "id";
				//Double wartosc = mapa.get(klucz);

				if (mapa.containsKey("id") && mapa.get(klucz).equals(4.0)) {
					String msg2 = "Podaj liczbę i znak działania:";
					outs.println(msg2);
					System.out.println("Serwer: " + msg2);

					String inputc2 = ins.readLine();
					System.out.println("Klient wysłał: " + inputc2);

					String[] tab2 = inputc2.split(" ");
					Double c = Double.parseDouble(tab2[0]);
					String y = tab2[1];

					for (Action item : Action.values()) {
						if (y.equals(item.getSign())) {
							Action action = item;
							OperationFactory factory = new OperationFactory();
							Double wynik = mapa.get("id");
							Double result2 = factory.getOperation(action).calculate(wynik, c);
							outs.println(result2);
							System.out.println("Serwer: " + result2);
						}
					}
				} else if (!(mapa.containsKey("id")) || (!(mapa.get(klucz).equals(4.0))) ) {
					String msg = "Wprowadz działanie matematyczne: ";
					outs.println(msg);
					System.out.println("Serwer: " + msg);

					String inputc = ins.readLine();
					System.out.println("Klient wysłał: " + inputc);

					String[] tab = inputc.split(" ");
					Double a = Double.parseDouble(tab[0]);
					String x = tab[1];
					Double b = Double.parseDouble(tab[2]);

					for (Action item : Action.values()) {
						if (x.equals(item.getSign())) {
							Action action = item;
							OperationFactory factory = new OperationFactory();
							double result = factory.getOperation(action).calculate(a, b);
							outs.println(result);
							System.out.println("Serwer: " + result);
							mapa.put("id", result);
						}
					}
				} else {
					System.out.println("nie wiem");
				}
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
