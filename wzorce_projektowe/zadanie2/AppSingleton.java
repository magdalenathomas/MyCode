package studia.wzorce_projektowe.zadanie2;

import java.util.Scanner;

public class AppSingleton {

	public static void main(String[] args) {
		
		Klawiatura klawiatura = Klawiatura.getInstance(); //stworzenie klawiatury
		//stworzenie klawiszy
		KlawiszAbstrakcyjny k1 = new Klawisz("a");
		KlawiszAbstrakcyjny k2 = new Klawisz("b");
		KlawiszAbstrakcyjny k3 = new Klawisz("c");
		KlawiszAbstrakcyjny k4 = new Klawisz("d");
		KlawiszAbstrakcyjny k5 = new Dekorator(k2);
		KlawiszAbstrakcyjny k7 = new Klawisz("f");
		KlawiszAbstrakcyjny k6 = new Dekorator1(new Dekorator1(k1));
		//System.out.println(k6.getKey());
		//System.out.println(k1.getKey());
		
		klawiatura.rejestrowanie(k6);
		klawiatura.rejestrowanie(k7);
		klawiatura.rejestrowanie(k3);
		klawiatura.rejestrowanie(k4);
		klawiatura.rejestrowanie(k5);
		
		//rejestrowanie klawiszy w klawiaturze

		
		System.out.println("Aby wyjść z programu wciśnij 'q'");
		System.out.println("------------------------------");
		while (true) {
			System.out.println("Wciśnij klawisz: ");
			Scanner read = new Scanner(System.in);
			String klucz = read.nextLine(); 
			if (klucz.equals("q")) {
				System.out.println("Koniec pracy programu");
				break;
			}
			//KlawiszAbstrakcyjny klawisz = new Dekorator(new Klawisz(klucz));
			klawiatura.sprawdzanie(klucz);
			}
	}

}
