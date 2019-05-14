package studia.wzorce_projektowe.proxy;

public class App {

	public static void main(String[] args) {

		Net net = new ProxyInternet();
		net.connection("facebook");
		net.connection("wp.pl");
	}

}
