package studia.wzorce_projektowe.zadanie2;

import java.util.Objects;

public class Klawisz implements KlawiszAbstrakcyjny{
	
	public String key;

	public Klawisz(String key) {
		this.key = key;
	}
	
	public void uaktualnij(KlawiszAbstrakcyjny key_pressed) {
		System.out.println("Wciśnięto klawisz: " + key_pressed.getKey());
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klawisz klawisz = (Klawisz) o;
        return Objects.equals(key, klawisz.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

	public String getKey() {
		return key;
	}

	public void update(KlawiszAbstrakcyjny key_pressed) {
		// TODO Auto-generated method stub
		
	}
}

