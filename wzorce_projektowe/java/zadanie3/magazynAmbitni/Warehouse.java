package zadanie3.magazynAmbitni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouse {
	
	static Warehouse instance;
	List <AddProduct> mag = new ArrayList<>();
	private Warehouse() {}

	public static Warehouse getInstance() {
		if (instance == null) {
			instance = new Warehouse();
		} 
		return instance;
	}
	
	public void dodawanie(AddProduct item) {
		
		System.out.println("Zawartość magazynu przed dodaniem nowego produktu: ");
		for(Object items : mag) {
			System.out.println(items);
		}
		System.out.println("-------------------------");
		
		if (!mag.contains(item)) {
			mag.add(item);
		}
		if(mag.contains(item)) {
			item.quantity++;
		}
		System.out.println("Dodany produkt: " + item + "łączna ilość w magazynie: " + item.quantity);
	}
	
	public void usuwanie(AddProduct item) {
		if(mag.contains(item)) {
			item.quantity--;
			if (item.quantity < 0) {
				mag.remove(item);
			}
		}
		System.out.println("Produkt: " + item + "łączna ilość w magazynie: " + item.quantity);
	}
	
	public void wypiszStan() {
		System.out.println("Stan magazynu: ");
		for(AddProduct items : mag) {
			System.out.println(items.getName() + " - " + items.quantity + " sztuk");
		}
	}
	

}
