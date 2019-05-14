package studia.wzorce_projektowe.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Net {
	
	private Net internet = new Internet();
	private static List<String> banned = new ArrayList<String>();
	
	static {
		banned.add("wp.pl");
		banned.add("onet.pl");
		banned.add("interia.pl");
	}

	public void connection(String server) {
		if (banned.contains(server)) {
			System.out.println("Site banned");
		}
		else {
			internet.connection(server);
		}
	}

}
