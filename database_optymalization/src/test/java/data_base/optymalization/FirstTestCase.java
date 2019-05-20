package data_base.optymalization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import junit.framework.TestCase;
import users.User;

public class FirstTestCase extends TestCase {
    final static int NUMBER_OF_USERS = 100;
    
    
  /* public void setUp() throws Exception {
        super.setUp();
        creating_data.DeleteAll.removeAll();
        creating_data.AddingAuthors.addingAuthors();
        creating_data.AddingCompany.addingCompany();
        creating_data.AddingBooks.addingBooks();
        creating_data.AddingUsers.addingUsers();
        creating_data.AddingOrders.addingOrders();

    }*/

    public void testFindAll() throws ExecutionException, InterruptedException {
        List<Future> futureList = new ArrayList<Future>();
        for(int i = 0; i < NUMBER_OF_USERS; i++) {
            User user = new User(Integer.toString(i));
            futureList.add(user.findAllBooks(0));
        }
        for (Future future : futureList) {
            future.get();
        }
    }

}
