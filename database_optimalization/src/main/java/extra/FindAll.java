package extra;

import repository.JPA;
import repository.model.BooksItem;

public class FindAll {

	public static void findAll() {

		JPA repo = null;
		repo = new JPA();
		
		BooksItem[] all = repo.findAll(6);
		for (int i = 0; i < all.length; i++) {
			BooksItem item = all[i];
			System.out.println();
			System.out.println("*****************************************************************************");
			System.out.println("Book " + (i + 1) + ":");
			System.out.println("Title: " + item.getTitle());
		}

	}
}
