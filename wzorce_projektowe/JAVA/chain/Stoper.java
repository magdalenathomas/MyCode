package studia.wzorce_projektowe.chain;

public class Stoper {

	private long start;
	private long stop;
	private String nazwa;

	public Stoper() {
	}

	public double start() {
		start = System.currentTimeMillis();
		return start;
	}

	public double stop() {
		stop = System.currentTimeMillis();
		return stop;
	}

	public double pobierzWynik() {
		return (stop - start) / 1000.0;
	}

	public String wynik() {
		return nazwa + ": " + pobierzWynik() + " s.";
	}

}
