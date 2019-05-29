package studia.wzorce_projektowe.memento;

public class Client {

	public static void main(String[] args) {

		//obiekt, którego stan należy zapamiętać
		Originator originator = new Originator();
		originator.setState("słonecznie");
		
		//stworzenie pamiątki
		Memento memento = originator.createMemento();
		
		//stworzenie opiekuna i dodanie pamiątki do jego pamięci
		Caretaker careTaker = new Caretaker();
		careTaker.addMemento(memento);
		
		//originator.setState("pochmurnie");
		originator.setState("deszczowo");
		memento = originator.createMemento();
		careTaker.addMemento(memento);
		
		originator.setState("mgliście");
		memento = originator.createMemento();
		careTaker.addMemento(memento);
		
		System.out.println("Obecna pogoda: " + originator.getState());
		System.out.println("Sprawdzanie wcześniejszej pogody...");
		memento = careTaker.getMemento(1);
		originator.setMemento(memento);
		System.out.println(originator.getState());
		System.out.println("Sprawdzanie jeszcze wcześniejszej pogody");
		memento = careTaker.getMemento(0);
		originator.setMemento(memento);
		System.out.println(originator.getState());
		
	}

}
