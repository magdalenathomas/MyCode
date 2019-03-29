package zadanie3.magazyn;

import java.util.Scanner;

public class Factory {
	
	public static void main(String[] args) {
		
		Warehouse magazyn = new Warehouse(2);
		Product mleko = new Product("Mućka", 2.98, "litr");
		Product chleb = new Product("Chrupek", 1.99, "sztuka");
		Product baton = new Product("Grzesiek", 0.78, "sztuka");
		Product ziemniaki = new Product("Bulwa", 0.56, "kilogram");
		
		/*magazyn.append(mleko);
		magazyn.append(chleb);
		magazyn.append(ziemniaki);
		magazyn.wypisz();
		
		magazyn.removal(mleko);
		magazyn.wypisz();
		
		magazyn.append(baton, 3);
		magazyn.wypisz(); */
		
		System.out.println("MAGAZYN");
		while (true) {
			System.out.println("Wybierz towar: ");
			Scanner read = new Scanner(System.in);
			Object wprowadz = read.nextLine();
			if(wprowadz.equals("q")) {
				System.out.println("Papa");
				break;
			}
			else if(wprowadz.equals("mleko")) {
				System.out.println("Wybrałeś mleko, wciśnij cyferkę co dalej: 1 - wprowadz do magazynu, 2 - wydaj towar");
			}
			else if(wprowadz.equals("baton")) {
				System.out.println("Wybrałeś baton, wciśnij cyferkę co dalej: 3 - wprowadz do magazynu, 4 - wydaj towar");
			}
			else {
				System.out.println("Nie ma takiego produktu");
			}
			
			
			Object liczba = read.nextLine();
			if (liczba.equals("1")) {
				magazyn.append(mleko);
				System.out.println("Produkt dodany do magazynu:");
				magazyn.wypisz();
			}
			else if (liczba.equals("2")) {
				magazyn.removal(mleko);
				System.out.println("Produkt usunięty z magazynu:");
				magazyn.wypisz();
			}
			else if (liczba.equals("3")) {
				magazyn.append(baton);
				System.out.println("Produkt dodany do magazynu:");
				magazyn.wypisz();
			}
			else if (liczba.equals("4")) {
				magazyn.removal(baton);
				System.out.println("Produkt usunięty z magazynu:");
				magazyn.wypisz();
			}
			else {
				System.out.println("Nie rozpoznano operacji");
			}
		}
	}
}