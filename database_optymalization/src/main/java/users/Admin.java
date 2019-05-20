package users;

import repository.BookRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Admin {
	BookRepository bookRepository = new BookRepository();
	ExecutorService executorService = Executors.newSingleThreadExecutor();
	public Admin() {
	}

    public void deleteBooksByYear(final int year, final long delay) {
		executorService.execute(new Runnable() {
			public void run() {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("usuwam " + year);
				bookRepository.deleteBooksOlderThan(year);
			}
		});
    }

	public Future updateAuthor(final int oldId, final int newId) {
		return executorService.submit(new Runnable() {
			public void run() {
				bookRepository.updateAuthor(oldId, newId);
			}
		});
	}
}
