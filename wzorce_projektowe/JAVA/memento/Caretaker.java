package studia.wzorce_projektowe.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

	private List<Memento> stateList = new ArrayList<Memento>();
	
	public void addMemento(Memento m) {
		stateList.add(m);
	}
	
	public Memento getMemento(int index) {
		return stateList.get(index);
	}
}
