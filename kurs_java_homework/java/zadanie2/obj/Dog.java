package zadanie2.obj;

public class Dog extends Ssak implements Pet {
	
	public String name;
	
	public Dog(String name) {
		this.name = name;
		System.out.println("Jestem psem, mam na imię " + name);
	}

	@Override
	public void weight(int mass) {
		System.out.println("Ważę: " + mass + "kg");
	}

	@Override
	public void atHome() {
		System.out.println("Jestem psem domowym");
	}

	@Override
	public void outdoor() {
		System.out.println("Mieszkam na podwórku");
	};

}
