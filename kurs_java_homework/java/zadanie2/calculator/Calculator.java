package zadanie2.calculator;

public class Calculator {
		
	public double number1;
	public double number2;
	public double result;
	public char sign;
	
	public Calculator(double number1, double number2) {
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public void sum() {
		result = number1 + number2;
		System.out.println("Wynik: " + result);
	}
	
	public void odds() {
		result = number1 - number2;
		System.out.println("Wynik: " + result);
	}
	
	public void product() {
		result = number1 * number2;
		System.out.println("Wynik: " + result);
	}
	
	public void quotient() {
		result = number1 / number2;
		System.out.println("Wynik: " + result);
	}
	
	

	
	
	
}
