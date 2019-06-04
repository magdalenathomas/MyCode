package users;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import repository.BookRepository;

public class Admin {
	BookRepository bookRepository = new BookRepository();
	ExecutorService executorService = Executors.newSingleThreadExecutor();

	public Admin() {
	}

	public Future deleteBook() {
		return executorService.submit(new Callable<Void>() {
			public Void call() throws Exception {
				bookRepository.deleteOne();
				return null;
			}
		});
	}

	public Future deleteBookByYear(final int year, final int delay) {
		return executorService.submit(new Callable<Void>() {
			public Void call() throws Exception {
				System.out.println("delete by year " + year);
				bookRepository.deleteByYear(year, delay);
				return null;
			}
		});
	}
}
