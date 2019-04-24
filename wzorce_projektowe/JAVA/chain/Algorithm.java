package studia.wzorce_projektowe.chain;

public abstract class Algorithm {
	
	protected Algorithm alg;
	
	public void setAlgorithm(Algorithm alg) {
		this.alg = alg;
	}
	
	public abstract void forwardRequest(int[] wektor);
}
