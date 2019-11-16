package clients;

public class Test {

	
	public static void main(String[] args) {

		//StopWatch watch = new StopWatch();
		
		long start = System.currentTimeMillis();
		for (int i=0; i<=100; i++) {
			System.out.println(i);
		}
		long now = System.currentTimeMillis();
		long odds = now - start;
		System.out.println("Czas: " + odds);
	}

}
