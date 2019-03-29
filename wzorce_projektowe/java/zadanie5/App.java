package zadanie5;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		
		System.out.println("-----------------------------------------------");
		System.out.println("Witaj w wyszukiwarce książek! Aby wyjść wciśnij 'q'");
		System.out.println("-----------------------------------------------");
		while (true) {
		System.out.println("Wprowadz  tytuł książki: ");
		Scanner read = new Scanner(System.in);
		String wpr = read.nextLine(); 
		if (wpr == "q") {
			System.out.println("Koniec pracy programu");
			break;
		}
		//DateBase.find(wpr);
	}

}
