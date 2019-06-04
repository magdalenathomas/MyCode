package data_base.optymalization;

import junit.framework.TestCase;
import users.Admin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FourthTestCase extends TestCase{

	/*public void setUp() throws Exception {
        super.setUp();
        creating_data.DeleteAll.removeAll();
        creating_data.AddingAuthors.addingAuthors();
        creating_data.AddingCompany.addingCompany();
        creating_data.AddingBooks.addingBooks();
        creating_data.AddingUsers.addingUsers();
        creating_data.AddingOrders.addingOrders();

    }*/
    public void testAuthorChange() throws ExecutionException, InterruptedException {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Future future = admin1.updateAuthor(1, 2);
        Future future1 = admin2.updateAuthor(2,3);
        future.get();
        future1.get();

    }

}
