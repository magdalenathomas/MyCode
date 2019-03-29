package studia.wzorce_projektowe.zadanie2;

public class Dekorator implements KlawiszAbstrakcyjny {
	
	KlawiszAbstrakcyjny unkey_pressed;
	public String key;
	
	public Dekorator(KlawiszAbstrakcyjny key_pressed) {
		unkey_pressed = key_pressed;
		this.key = key_pressed.getKey();
	}
	
	public void uaktualnij(KlawiszAbstrakcyjny key_pressed) {
		unkey_pressed.uaktualnij(key_pressed);
		System.out.println("!");
	}
	
	public String getKey() {
		return key;
	}

	
}
