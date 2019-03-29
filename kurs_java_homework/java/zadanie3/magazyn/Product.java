package zadanie3.magazyn;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable  {

	protected String name;
	protected double price;
	protected String unit;
	
	public Product(String name, double price, String unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
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
