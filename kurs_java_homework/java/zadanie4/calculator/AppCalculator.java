package zadanie4.calculator;

import java.util.Scanner;

public class AppCalculator {
	
	public static void main(String[] args) {
		
		Sum dodawanie = new Sum();
		Odds odejmowanie = new Odds();
		Product mnozenie = new Product();
		Quotient dzielenie = new Quotient();

	String operation;	
		
	System.out.println();
	System.out.println("-----------------------------------------------");
	System.out.println("Witaj w kalkulatorze! Aby wyjść wciśnij 'q'");
	System.out.println("-----------------------------------------------");
	while (true) {
		try {
			System.out.println("Wprowadz działanie matematyczne:");
			Scanner read = new Scanner(System.in);
			operation = read.nextLine();
			if(operation.equals("q")) {
				System.out.println("Koniec pracy programu");
				break;
			}
			
			String[] tab = operation.split(" ");
			Double a = Double.parseDouble(tab[0]);
			String x = tab[1];
			Double b = Double.parseDouble(tab[2]);
			char cmd = x.charAt(0);

			switch (cmd) {
			case '+':
				dodawanie.calculate(a, b);
				break;
			case '-':
				odejmowanie.calculate(a, b);
				break;
			case '*':
				mnozenie.calculate(a, b);
				break;
			case '/':
				dzielenie.calculate(a, b);
				break;
			}
			} catch (NumberFormatException e) {
				System.out.println("Błąd wprowadzania");
			}
		}
	}
}
