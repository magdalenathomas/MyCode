package studia.wzorce_projektowe.chain;

public class Cubic_Algorithm extends Algorithm {

	@Override
	public void forwardRequest(int[] wektor) {
		Stoper stoper = new Stoper();
		stoper.start();
		
		int maxsofar =0;
		int i= wektor[0];
		int j=wektor[wektor.length-1];
		int n=wektor.length;
		int k=0;
		for (i = 0; i <= n-1; i++) {
			for (j=0; j<= n-1; j++) {
				int sum =0;
				for (k=i; k<=j; k++) {
					sum += wektor[k];
					maxsofar = Math.max(maxsofar, sum);
				}
			}
		} 
		
		stoper.stop();
		//System.out.println(stoper.pobierzWynik());
		
		if (stoper.pobierzWynik() <= 0.010) {
			System.out.println("Algorytm sześcienny: " + maxsofar);
		}
		else {
			alg.forwardRequest(wektor);
		}
		
		
	}
}
