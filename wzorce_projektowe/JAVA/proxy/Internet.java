package studia.wzorce_projektowe.proxy;

public class Internet implements Net {

	public void connection(String server) {
			System.out.println("Connected to: " + server);
	}

}
