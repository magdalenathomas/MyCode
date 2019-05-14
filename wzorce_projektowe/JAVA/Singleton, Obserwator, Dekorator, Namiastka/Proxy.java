package studia.wzorce_projektowe.zadanie2;

public class Proxy implements KlawiszAbstrakcyjny {
	
	String klucz;
	Klawiatura klawiatura;

	public Proxy(String klucz) {
		this.klucz=klucz;
	}
	
	public void update(KlawiszAbstrakcyjny key_pressed) {
		if (key_pressed.getKey().equals("w")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("e")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("r")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("t")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("y")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("u")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("i")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("o")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		}
		else if (key_pressed.getKey().equals("p")) {
			Klawisz klawisz = new Klawisz(key_pressed.getKey());
			klawisz.uaktualnij(key_pressed);
		} 
	}

	public String getKey() {
		return klucz;
	}

	public void uaktualnij(KlawiszAbstrakcyjny key_pressed) {
		// TODO Auto-generated method stub
		
	}
}
