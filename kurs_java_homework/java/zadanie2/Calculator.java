package zadanie2;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		String operation;
		System.out.println("Witaj w kalkulatorze!");
		System.out.println("Aby zakończyć działanie aplikacji naciśnij przycisk q");

		while (true) {
			try {
				System.out.println("Wprowadz działanie matematyczne:");
				Scanner read = new Scanner(System.in);
				operation = read.nextLine();
				if(operation.equals("q")) {
					System.out.println("Papa");
					break;
				}

				String[] tab = operation.split(" ");
				Double a = Double.parseDouble(tab[0]);
				String x = tab[1];
				Double b = Double.parseDouble(tab[2]);
				double wynik;
				switch (x) {
				case "+":
					wynik = a + b;
					System.out.println("Suma: " + wynik);
					break;
				case "-":
					wynik = a - b;
					System.out.println("Różnica: " + wynik);
					break;
				case "*": 
					wynik = a * b;
					System.out.println("Iloczyn: " + wynik);
					break;
				case "/": 
					wynik = a / b;
					System.out.println("Iloraz: " + wynik);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Błąd wprowadzania");
			}

		}
	}
}
