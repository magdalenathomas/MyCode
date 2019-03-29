package zadanie3.magazynAmbitni;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		//stworzenie magazynu
		Warehouse mag = Warehouse.getInstance();
		
		//stworzenie produktow
		AddProduct mleko = new AddProduct("Łaciate", "2.49", "litr");
		AddProduct sok = new AddProduct("Cappy", "3.70", "litr");
		AddProduct jablko = new AddProduct("Champion", "0.99", "kg");
		AddProduct baton = new AddProduct("Grzesiek", "1.59", "szt");
		AddProduct chipsy = new AddProduct("Star", "3.50", "sztuka");
		AddProduct maka = new AddProduct("Krupczatka", "2.40", "kg");
		
		//dodanie produktow do magazynu
		mag.dodawanie(baton);
		mag.dodawanie(baton);
		mag.dodawanie(jablko);
		mag.dodawanie(sok);
		//mag.usuwanie(baton);
		//mag.usuwanie(baton);
		
		mag.wypiszStan();
		//komunikacja z użytkownikiem
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Witaj w magazynie! Aby wyjść wciśnij 'q'");
		System.out.println("-----------------------------------------------");
		while (true) {
		System.out.println("Wprowadz nazwe produktu: ");
		Scanner read = new Scanner(System.in);
		String nazwa = read.nextLine(); 
		if (nazwa == "q") {
			System.out.println("Koniec pracy programu");
			break;
		}
		System.out.println("Wprowadz cene produktu: ");
		Scanner readd = new Scanner(System.in);
		String cena = readd.nextLine(); 
		if (cena == "q") {
			System.out.println("Koniec pracy programu");
			break;
		}
		System.out.println("Wprowadz jednostke produktu: ");
		Scanner readdd = new Scanner(System.in);
		String jednostka = readdd.nextLine(); 
		if (jednostka == "q") {
			System.out.println("Koniec pracy programu");
			break;
		}
		AddProduct p1 = new AddProduct(nazwa, cena, jednostka);
		System.out.println("Wciśnij: \n "
				+ "1 - aby dodać produkt do magazynu \n"
				+ "2 - aby usunąć produkt z magazynu \n"
				+ "3 - aby wyświetlić stan magazynu");
		Scanner reader = new Scanner(System.in);
		String wprowadzenie = reader.nextLine();
		if (wprowadzenie == "q") {
			System.out.println("Koniec pracy programu");
		}
		Double liczba = Double.parseDouble(wprowadzenie);
		if (liczba == 1) {
			mag.dodawanie(p1);
		} else if (liczba == 2) {
			mag.usuwanie(p1);
		} else if (liczba == 3) {
			mag.wypiszStan();
		} else {
			System.out.println("Nie ma takiej akcji");
		}
		}
		//System.out.println(p1);
		
		
	}

}
