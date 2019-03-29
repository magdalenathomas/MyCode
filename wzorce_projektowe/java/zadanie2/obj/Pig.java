package zadanie2.obj;

public class Pig extends Ssak implements Pet {

	public boolean isHungry;
	
	
	public Pig(){
		System.out.println("Jestem świnią");
	}
	
	public void feed() {
		isHungry = false;
	}
	
	@Override
	public void weight(int mass) {
		System.out.println("Ważę dużo, bo aż " + mass + "kg");
	}

	@Override
	public void atHome() {
		System.out.println("Jestem świnią domową, mieszkam w domu");
	}

	@Override
	public void outdoor() {
		System.out.println("Mieszkam w stajni");
	}

}
