package zadanie1;

public class TablicaMalarska {

	public static void main(String[] args) {
		String[][] tab = new String[8][16];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 16; y++) {
				if (x == 5 || x == 7) {
					tab[x][y] = ("*");
					//System.out.println();
				} else if ((x == 4 && y == 0) || (x == 4 && y == 15)) {
					tab[x][y] = ("*");
					//System.out.println();
				} else if ((x == 7 && y == 0) || (x == 7 && y == 15)) {
					tab[x][y] = ("*");
					//System.out.println();
				} else if ((x == 0 && y == 8) || (x == 1 && y == 7) || (x == 1 && y == 9)) {
					tab[x][y] = ("*");
					//System.out.println();
				} else if ((x == 2 && y == 8) || (x == 1 && y == 7) || (x == 1 && y == 9)) {
					tab[x][y] = ("*");
				} else {
					System.out.println(" "); 
				}
			}
				//System.out.println();
			} 
		
		wypisz(tab);
	}
		
		
	
		static void wypisz(String[][] tab) {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 16; y++) {
				System.out.println(tab[x][y]);
			}
		}
		}
		
		
}
