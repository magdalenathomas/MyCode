package homework1.joke;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 8080);
			BufferedReader inc = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream outc = new PrintStream(s.getOutputStream());

			List<String> names = new ArrayList<String>();
			BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\Magda\\Desktop\\imiona.txt"));
			while (true) {
				String line = fileReader.readLine();
				if (line != null) {
					names.add(line);
				} else {
					break;
				}
			}

			Random r = new Random();
			int index = r.nextInt(names.size());

			String msg = "Puk puk";
			outc.println(msg);
			System.out.println("Klient: " + msg);

			String sanswer = inc.readLine();
			if (sanswer.equals("Kto tam?")) {
				System.out.println("Serwer wysłał: " + sanswer);
				String odp = names.get(index);
				outc.println(odp);
				System.out.println("Klient: " + odp);
			} else {
				System.out.println("Serwer nic nie odpowiedział");
			}

			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
