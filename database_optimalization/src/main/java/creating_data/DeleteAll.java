package creating_data;

import repository.AuthorRepository;
import repository.BookRepository;
import repository.CompanyRepository;
import repository.JPA;

public class DeleteAll {

	public static void removeAll() throws Exception {

		AuthorRepository authorRepository = new AuthorRepository();
		JPA repo = new JPA();
		BookRepository bookRepository = new BookRepository();
		CompanyRepository companyRepository = new CompanyRepository();
		repo.deleteAllOrders();
		repo.deleteAllUsers();
		bookRepository.deleteAll();
		companyRepository.deleteAll();
		authorRepository.deleteAll();
	}

}
