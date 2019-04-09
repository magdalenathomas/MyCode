package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.AuthorsItem;

public class AddingAuthors {

	public static void addingAuthors() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		for (int i = 0; i < 100; i++) {
			String author_name = df.getFirstName();
			String author_surname = df.getLastName();
			AuthorsItem author = new AuthorsItem(author_name, author_surname);
			repo.save(author);
		}
	}

}
