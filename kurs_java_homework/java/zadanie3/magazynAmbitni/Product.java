package zadanie3.magazynAmbitni;

public abstract class Product {
	
	protected String name;
	protected String price;
	protected String unit;
	
	public Product(String name, String price, String unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getUnit() {
		return unit;
	}
	
	@Override
	public String toString() {
		return name + " " + price + "zł  " + "(" + unit +  ")" + "\n";
	}
}
