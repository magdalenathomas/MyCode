package data_base.optymalization;

import junit.framework.TestCase;
import repository.model.BooksEntity;
import users.Admin;
import users.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by U118788 on 5/16/2019.
 */
public class ThirdTestCase extends TestCase {
    static final Integer OLDER_THAN=1990;
    
    public void setUp() throws Exception {
        super.setUp();
        creating_data.DeleteAll.removeAll();
        creating_data.AddingAuthors.addingAuthors();
        creating_data.AddingCompany.addingCompany();
        creating_data.AddingBooks.addingBooks();
        creating_data.AddingUsers.addingUsers();
        creating_data.AddingOrders.addingOrders();

    }
    public void testRemoveData() throws ExecutionException, InterruptedException {
        List<Future> futureList = new ArrayList<Future>();
        for(int i = 0; i<5; i++) {
            User user = new User(Integer.toString(i));
            long delay = (long)(Math.random() * 9000)+1000;
            Future<Collection<BooksEntity>> booksOlderThan = user.findBooksOlderThan(OLDER_THAN, delay);
            futureList.add(booksOlderThan);
        }
        for(int i = 1960; i<1970; i++) {
            Admin admin = new Admin();
            long delay = Math.max(1000, (long)(Math.random() * 9000) - 1000);
            admin.deleteBooksByYear(i, delay);
        }
        for (Future future : futureList) {
            future.get();
        }
    }
}
