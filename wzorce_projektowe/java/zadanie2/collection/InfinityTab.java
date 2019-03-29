package zadanie2.collection;

public class InfinityTab implements Appendable {
	
	Object[] tab;
	
	public InfinityTab(int size) {
		tab = new Object [size];
	}
	
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
	
	public void wypisz() {
		for (int x=0; x<tab.length; x++) {
			System.out.println(tab[x]);
		}
	}

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
}
