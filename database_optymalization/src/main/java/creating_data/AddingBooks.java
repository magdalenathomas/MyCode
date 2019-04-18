package creating_data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.AuthorsEntity;
import repository.model.BooksItem;
import repository.model.CompanyEntity;

public class AddingBooks {
	public static void addingBooks() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		Collection<CompanyEntity> allCompanies = repo.findAllCompanies();
		Collection<AuthorsEntity> allAuthors = repo.findAllAuthors();
		for (int i = 1; i < 100; i++) {
			int id_books = i;
			String title = df.getRandomWord();
			CompanyEntity item = (CompanyEntity) df.getItem(new ArrayList(allCompanies));

			Set<AuthorsEntity> authorsEntityList = new HashSet<AuthorsEntity>();

			AuthorsEntity author = (AuthorsEntity) df.getItem(new ArrayList(allAuthors));
			authorsEntityList.add(author);
			for(int z = 0; z < 3; z++) {
				author = (AuthorsEntity) df.getItem(new ArrayList(allAuthors), 50);
				if(author != null) {
					authorsEntityList.add(author);
				}
			}

			int year = df.getNumberBetween(1960, 2019);
			BooksItem book = new BooksItem(id_books ,title, year, item, authorsEntityList);
			repo.save(book);

		}
	}
}
