package zadanie1;

public class Kwadarty {

	public static void main(String[] args) {
		int col = 14;
		int row = 8;
		
		for(int x=0; x<row; x++) {
			for (int y=0; y<col; y++) {
				if (x > 1 && x < (row-2) && y < (col-2) && y > 1) {
					System.out.print(" ");
					} 
					else System.out.print("*");
				}
				System.out.println();
		}
	}

}
