package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.BooksItem;

public class AddingBooks {
	public static void addingBooks() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		for (int i = 0; i < 100; i++) {
			int id_books = i;
			String title = df.getRandomWord();
			int year = df.getNumberBetween(1960, 2019);
			BooksItem book = new BooksItem(id_books ,title, year);
			repo.save(book);
		}
	}
}
