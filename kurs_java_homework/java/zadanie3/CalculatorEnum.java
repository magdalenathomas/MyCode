package zadanie3;

import java.util.Scanner;

	public enum CalculatorEnum {
		SUM ('+'), 
		ODDS ('-'), 
		PRODUCT ('*'), 
		QUOTIENT('/');
		
	private char cmd;		
				
	private CalculatorEnum (char cmd) {
		this.cmd = cmd;
	}
	
	public char getCmd() {
		return cmd;
	}
	
	public static CalculatorEnum getByCmd(char cmd) {
        for(CalculatorEnum item : CalculatorEnum.values()) {
              if(item.getCmd() == cmd) {
            	  return item;
              }
        }  return null;
	}
	
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
				char cmd = x.charAt(0);
				
				CalculatorEnum znak = CalculatorEnum.getByCmd(cmd);
				
			switch(znak) {
				case SUM:
					wynik = a + b;
					System.out.println("Suma: " + wynik);
					break;
				case ODDS:
					wynik = a - b;
					System.out.println("Różnica: " + wynik);
					break;
				case PRODUCT:
					wynik = a * b;
					System.out.println("Iloczyn: " + wynik);
					break;
				case QUOTIENT:
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