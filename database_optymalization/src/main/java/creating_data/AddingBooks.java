package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.CompanyRepository;
import repository.model.AuthorsEntity;
import repository.model.BooksItem;
import repository.model.CompanyEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AddingBooks {
	public static void addingBooks() throws Exception {

		BookRepository bookRepository = new BookRepository();
		CompanyRepository companyRepository = new CompanyRepository();
		AuthorRepository authorRepository = new AuthorRepository();

		DataFactory df = new DataFactory();
		Collection<CompanyEntity> allCompanies = companyRepository.findAll();
		Collection<AuthorsEntity> allAuthors = authorRepository.findAll();
		for (int i = 1; i < 10000; i++) {
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
			bookRepository.save(book);

		}
	}
}
