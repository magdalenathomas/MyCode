package studia.wzorce_projektowe.chain;

import java.util.Random;

public class App {

	public static void main(String[] args) {

		Random rnd = new Random();
		int wektor[] = new int[5];
		for (int i=0; i<wektor.length; i++) {
			wektor[i]= rnd.nextInt(10);
		}
		
		Cubic_Algorithm szescienny = new Cubic_Algorithm();
		Square_Algorithm kwadartowy = new Square_Algorithm();
		Linear_Algorithm liniowy = new Linear_Algorithm();
		szescienny.setAlgorithm(kwadartowy);
		kwadartowy.setAlgorithm(liniowy);
		
		szescienny.forwardRequest(wektor);
	
	}

}
