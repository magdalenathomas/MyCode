package extra;

import repository.JPA;
import repository.model.BooksItem;

public class FindBooks {

	public static void findBooks() {
		
		JPA repo = null;
		repo = new JPA();
		
		BooksItem[] all = repo.find();
		for (int i = 0; i < all.length; i++) {
			BooksItem item = all[i];
			System.out.println();
			System.out.println("*****************************************************************************");
			System.out.println("Book " + (i + 1) + ":");
			System.out.println("Title: " + item.getTitle());
			System.out.println("Year: " + item.getYear());
		}
	}
}
