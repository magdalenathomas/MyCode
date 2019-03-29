package studia.wzorce_projektowe.zadanie2;

public interface KlawiszAbstrakcyjny {
	
	//public String key;
	
	//public KlawiszAbstrakcyjny(String key) {
		///this.key = key;
	//}

	public void uaktualnij(KlawiszAbstrakcyjny key_pressed);
	
	public String getKey();
}
