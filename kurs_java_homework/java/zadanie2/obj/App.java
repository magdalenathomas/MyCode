package zadanie2.obj;

public class App {

	public static void main(String[] args) {
		
		Dog pies = new Dog("Reksio");
		pies.weight(23);
		pies.age(3);
		
		Pig swinia = new Pig();
		swinia.feed();
		swinia.weight(250);
		swinia.whatSex("maciorą");
		
		Pet morska = swinia;
		morska.atHome();
		
		Ssak kobieta = pies;
		kobieta.whatSex("suka");
		
	}

}
