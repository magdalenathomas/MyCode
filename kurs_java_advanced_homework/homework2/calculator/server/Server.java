package homework2.calculator.server;

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
			if(x.equals(item.getSign())) {
				Action action = item;
				OperationFactory factory = new OperationFactory();
				double result = factory.getOperation(action).calculate(a, b);
				outs.println(result);
				System.out.println("Serwer: " + result);
			}
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

