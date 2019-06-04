package extra;

import junit.framework.TestCase;
import users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by U118788 on 5/16/2019.
 */
/*użytkownicy chcą wyświetlić wszystkie książki z biblioteki*/
public class FirstTestCase extends TestCase {
    final static int NUMBER_OF_USERS = 20;

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
