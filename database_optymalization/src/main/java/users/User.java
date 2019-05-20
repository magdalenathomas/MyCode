package users;

import repository.BookRepository;
import repository.model.BooksEntity;

import java.util.Collection;
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

	public Future<Collection<BooksEntity>> findAllBooks(final long delay) {
		Future<Collection<BooksEntity>> userTask = executorService.submit(new Callable<Collection<BooksEntity>>() {
			public Collection<BooksEntity> call() throws Exception {
				Thread.sleep(delay);
				System.out.println(name + " szukam wszystkich ksiazek");
				Collection<BooksEntity> all = bookRepository.findAll();
				System.out.println(name + " znalazlem: " + all.size() + " ksiazek");
				return all;
			}
		});
		return userTask;
	}
	public Future<Collection<BooksEntity>> findBooksOlderThan(final int year, final long delay) {
		Future<Collection<BooksEntity>> userTask = executorService.submit(new Callable<Collection<BooksEntity>>() {
			public Collection<BooksEntity> call() throws Exception {
				Thread.sleep(delay);
				System.out.println(name + " szukam ksiazek starszych niz " + year);
				Collection<BooksEntity> booksOlderThan = bookRepository.findBooksOlderThan(year);
				System.out.println(name + " znalazlem: " + booksOlderThan.size() + " ksiazek");
				return booksOlderThan;
			}
		});
		return userTask;
	}
	public Future<Collection<BooksEntity>> findByCity(final String city) {
		Future<Collection<BooksEntity>> userTask = executorService.submit(new Callable<Collection<BooksEntity>>() {
			public Collection<BooksEntity> call() throws Exception {
				System.out.println(name + " szukam po miescie " + city);
				Collection<BooksEntity> byCity = bookRepository.findByCity(city);
				System.out.println(name + " znalazlem " + byCity.size());
				return byCity;
			}
		});
		return userTask;
	}
}
