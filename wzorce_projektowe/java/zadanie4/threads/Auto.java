package zadanie4.threads;

public class Auto implements Runnable {

	private int speed;
	private boolean isStop;
	private double distance;
	private double length; //droga po 1 sekundzie ruchu
	private int changedSpeed;
	
	public Auto(int speed) {
		this.speed = speed;
		isStop = false;
		distance = 0;
		getLength();
	}
	
	public double getLength() {
		length = (speed *1000)/3600;
		return length;
	}
	
	public int alterSpeed(int addedSpeed) {
		speed = speed + addedSpeed;
		return speed;
	}
	
	@Override
	public void run() {
		while (!isStop) {
			if (changedSpeed > speed) {
				speed = changedSpeed;
			}
			if (distance >= 500) {
				isStop = true;
				System.out.println("Przejechałem 500m, zatrzymałem się.");
				break;
			}
			System.out.println("Jadę z prędkością " + speed + "km/h, przejechałem " + distance + "m.");
			distance += length;
			//alterSpeed(10);
			getLength();
		
		}
		
	}
}
