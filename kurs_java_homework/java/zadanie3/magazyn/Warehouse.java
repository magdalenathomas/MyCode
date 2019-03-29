package zadanie3.magazyn;

public class Warehouse implements Appendable {
	
	Object tab[];
	
	public Warehouse(int size) {
		tab = new Object[size];
	}

	//przyjmowanie towaru
	@Override
	public Appendable append(Object item) {
		for (int x=0; x<tab.length; x++) {
			if (tab[x] == null) {
				tab[x] = item;
				break;
			} else {
				System.out.println("Tablica skończona");
			}
		}
		return this;
	}
	
	//przyjmowanie towaru na konkretne miejsce
	@Override
	public Appendable append(Object item, int index) {
		if(index < tab.length) {
			tab[index] = item;
		} else {
			Object[] newTab = new Object[index + 1];
			for(int i = 0; i < tab.length; i++) {
				newTab[i] = tab[i];
			}
			newTab[index] = item;
			tab = newTab;
		}
		return this;
	}
	
	//wydawanie towaru
	public Object removal(Object item) {
		for (int x=0; x<tab.length; x++) {
			if (tab[x] == item) {
				tab[x] = null;
				break;
			} else {
				System.out.println("Nie znaleziono produktu");
			}
		}
	return this;	
	}
	
	//wypisanie wszystkiego co jest w magazynie
	public void wypisz() {
	for (int x=0; x<tab.length; x++) {
		System.out.println(tab[x]);
		}
	}
}
