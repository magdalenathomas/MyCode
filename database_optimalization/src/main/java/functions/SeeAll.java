package functions;

import repository.JPA;
import repository.model.BooksItem;

public class SeeAll {
	
	public static void seeAll() {

		JPA repo = null;
		repo = new JPA();
		
		BooksItem[] all = repo.getAll();
		for (int i = 0; i < all.length; i++) {
			BooksItem item = all[i];
			System.out.println();
			System.out.println("*****************************************************************************");
			System.out.println("Book " + (i + 1) + ":");
			System.out.println("Title: " + item.getTitle());
		}

	}
}
