package zadanie1;

public class TrianglePainter {

	public static void main(String[] args) {
		
		//pętla rysująca spacje
		for (int x=0; x<8; x++) {
			for (int y=0; y<4; y++) {
				if (x == 2 && (y<5 && y>0)) {
					System.out.println("*");
				}
				else if (x == 1 && y == 2) {
					System.out.println("*");
				}
				else if (x == 3) {
					System.out.println("-");
				}
			}
		}
		
		/*while (true) {
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 6; y++) {
					else if ((x == 1 && y == 1) || (x == 2 && y == 1) || (x == 0 && y == 2)) {
						System.out.print("/");
					}
					else if ((x == 0 && y == 3) || (x == 0 && y == 3) || (x == 1 && y == 4) || (x == 2 && y == 5)) {
						System.out.print("\\");
						System.out.println();
					} else if (x == 3) {
						System.out.print("-");
					}
				}
			}
			break;
		} 
	} 
} 

//if ((x==0 && y==0) || (x==0 && y==1) || (x==0 && y==4) || (x==0 && y==5) || (x==1 && y==0) || (x==1 && y==5)) {
*/
}
}