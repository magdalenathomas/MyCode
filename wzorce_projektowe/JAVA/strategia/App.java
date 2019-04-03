package studia.wzorce_projektowe.strategia;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		System.out.println("Wprowadz dostępne środki pieniężne: ");
		Scanner read = new Scanner(System.in);
		int kasa = read.nextInt();
		int money = kasa;
		System.out.println("Wprowadz czas do dyspozycji: ");
		Scanner readd = new Scanner(System.in);
		int czas = readd.nextInt();
		int time = czas;
		System.out.println("Wprowadz ryzyko uszkodzenia przedmiotu: 1 - male, 2 - srednie, 3 - duze");
		Scanner readdd = new Scanner(System.in);
		int wartosc = readdd.nextInt();
		int value = wartosc;

		Context context = new Context();

		if (money < 3) {
			context.set(new Bike());
			context.wybor();
		} else if (money >= 20) {
			context.set(new Taxi());
			context.wybor();
		} else if (money < 20 && money >= 3) {
			context.set(new PublicTransport());
			context.wybor();
		} else if (money >= 20 && value == 1 && time >= 15 ) {
			context.set(new Taxi());
			context.wybor();
		} else if (value > 1 && time >= 30) {
			context.set(new Bike());
			context.wybor();
		}

	}
}
