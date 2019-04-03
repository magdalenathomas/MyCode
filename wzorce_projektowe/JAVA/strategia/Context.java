package studia.wzorce_projektowe.strategia;

public class Context {

	private Strategy strategia;
	
	public void set(Strategy strategia) {
		this.strategia = strategia;
	}

	public void wybor() {
		strategia.Travel();
	}
	
}
