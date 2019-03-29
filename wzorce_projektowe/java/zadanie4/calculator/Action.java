package zadanie4.calculator;

public enum Action {
	Sum("+"), Odds("-"), Product("*"), Quotient("/");
	
	private String sign;
	
	private Action(String sign) {
		this.sign = sign;
	}
	
	public String getSign() {
		return sign;
	}
}
