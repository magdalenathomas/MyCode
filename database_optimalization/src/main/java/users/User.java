package users;

import repository.AuthorRepository;
import repository.BookRepository;
import repository.model.AuthorsEntity;
import repository.model.BooksEntity;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class User {
	BookRepository bookRepository = new BookRepository();

	ExecutorService executorService = Executors.newSingleThreadExecutor();
	String name;

	public User(String str) {
		name = str;
	}

	public Future<Collection<BooksEntity>> findAllBooks() {
		return executorService.submit(new Callable<Collection<BooksEntity>>() {
			public Collection<BooksEntity> call() throws Exception {
				Collection<BooksEntity> all = bookRepository.findAll();
				System.out.println(name + " znalazlem: " + all.size() + " ksiazek");
				return all;
			}
		});
	}

	public Future<Collection<BooksEntity>> findBookByAuthor() {
		return executorService.submit(new Callable<Collection<BooksEntity>>() {
			public Collection<BooksEntity> call() throws Exception {
				Collection<AuthorsEntity> all = new AuthorRepository().findAll();
				for (AuthorsEntity authorsEntity : all) {
					if (new Random().nextInt(10) % 5 == 0) {
						System.out.println("Autor " + authorsEntity.getAuthor_name() + "posiada "
								+ authorsEntity.getBooksEntity().size() + " ksiazek");
						return authorsEntity.getBooksEntity();
					}
				}
				return null;
			}
		});
	}
}
