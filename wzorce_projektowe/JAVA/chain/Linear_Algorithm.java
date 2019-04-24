package studia.wzorce_projektowe.chain;

public class Linear_Algorithm extends Algorithm {

	@Override
	public void forwardRequest(int[] wektor) {
		Stoper stoper = new Stoper();
		stoper.start();

		int maxsofar = 0;
		int maxhere = 0;
		int i = wektor[0];
		int n = wektor.length;
		for (i = 0; i <= n - 1; i++) {
			maxhere = Math.max(maxhere + wektor[i], 0);
			maxsofar = Math.max(maxsofar, maxhere);
		}

		stoper.stop();
		System.out.println(stoper.pobierzWynik());
		
		System.out.println("Algorytm liniowy " + maxsofar);
	}
}
