package zadanie2.collection;

public class App {

	public static void main(String[] args) {

		InfinityTab tablica = new InfinityTab(6);
		tablica.append("sss");
		tablica.wypisz();
		System.out.println("---------------------");
		
		InfinityTab tablica2 = new InfinityTab(2);
		tablica2.append("kot", 2);
		tablica2.wypisz();
		
	}

}
