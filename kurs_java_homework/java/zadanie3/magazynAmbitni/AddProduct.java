package zadanie3.magazynAmbitni;

public class AddProduct extends Product {

	public int quantity;
	
	public AddProduct(String name, String price, String unit) {
		super(name, price, unit);
		quantity = 0;
	}

	
}
