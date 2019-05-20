package users;

import repository.BookRepository;
import repository.CompanyRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Moderator {
    BookRepository bookRepository = new BookRepository();
    CompanyRepository companyRepository = new CompanyRepository();

	ExecutorService executorService = Executors.newSingleThreadExecutor();

	public Moderator() {
		
	}

	public void updateCity(final String oldName, final String newName) {
		executorService.execute(new Runnable() {
			public void run() {
				companyRepository.updateCity(oldName,newName);
			}
		});

	}
}
