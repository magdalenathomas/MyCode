package zadanie4.threads;

public class AppThreads {
	
	public static void main(String[] args) throws InterruptedException{
		
	
		Auto a1 = new Auto(100);
		Auto a2 = new Auto(50);
		Thread th1 = new Thread(a1);
		Thread th2 = new Thread(a2);
		th1.start();
		//Thread.sleep(1000);
		th2.start();
		
	}

}
