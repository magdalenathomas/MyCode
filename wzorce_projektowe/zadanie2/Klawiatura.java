package studia.wzorce_projektowe.zadanie2;

import java.util.ArrayList;
import java.util.List;

public class Klawiatura {

	private static Klawiatura instance;
	public String key_pressed;
	List <KlawiszAbstrakcyjny> klawiatura= new ArrayList<KlawiszAbstrakcyjny>();
	
	private Klawiatura() {
		
	}

	public static Klawiatura getInstance() {
		if (instance == null) {
			instance = new Klawiatura();
		} 
		return instance;
	}

	public void rejestrowanie(KlawiszAbstrakcyjny klawisz) {
		klawiatura.add(klawisz);
		System.out.println("Dodano klawisz: " + klawisz.getKey());
	}
	
	public void odrejestrowywanie(KlawiszAbstrakcyjny klawisz) {
		klawiatura.remove(klawisz);
		System.out.println("Usunięto klawisz: " + klawisz.getKey());
	}
	
	/*public void sprawdzanie(KlawiszAbstrakcyjny klawisz) {
		key_pressed = klawisz.getKey();
		
		for (int i=0; i<klawiatura.size(); i++) {
			KlawiszAbstrakcyjny k = klawiatura.get(i);
			String key = k.getKey();
			if(key_pressed.equals(key)) {
				powiadom(klawisz);
				break;
			} 
			if (!klawiatura.contains(klawisz)) {
				System.out.println("Brak przycisku");
				return;
			}
			
		}
	}*/
	
	public void sprawdzanie(String klucz) {
		for (int i=0; i<klawiatura.size(); i++) {
			KlawiszAbstrakcyjny k = klawiatura.get(i);
			String key = k.getKey();
			if(klucz.equals(key)) {
				powiadom(k);
				break;
			}
			/*if (!(klucz.equals(key))) {
				System.out.println("Brak przycisku");
				return;
			}*/
			
		}
	}
	
	public void powiadom(KlawiszAbstrakcyjny klawisz) {
		klawisz.uaktualnij(klawisz);
		odrejestrowywanie(klawisz);;
	}
}
