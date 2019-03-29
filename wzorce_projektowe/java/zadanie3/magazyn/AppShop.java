package zadanie3.magazyn;

import java.io.IOException;

@SuppressWarnings("serial")
public class AppShop extends Product {
	
	public AppShop(String name, double price, String unit) {
		super(name, price, unit);
	}
	
	public static void main(String[] args) {
		
		AppShop mleko = new AppShop("Mućka", 2.98, "litr");
		AppShop chleb = new AppShop("Chrupek", 1.99, "sztuka");
		AppShop baton = new AppShop("Grzesiek", 0.78, "sztuka");
		AppShop ziemniaki = new AppShop("Bulwa", 0.56, "kilogram");
		
		
		System.out.println(mleko.toString());	
	}
	
}