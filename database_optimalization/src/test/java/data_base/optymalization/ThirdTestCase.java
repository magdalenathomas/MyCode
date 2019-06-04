package data_base.optymalization;

import junit.framework.TestCase;
import users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ThirdTestCase extends TestCase {
    final static int NUMBER_OF_USERS = 50;

    public void testfirst() throws InterruptedException, ExecutionException {
        List<Future> futureList = new ArrayList<Future>();
        for(int i = 0; i < NUMBER_OF_USERS; i++) {
            User user = new User(Integer.toString(i));
            futureList.add(user.findAllBooks());
        }
        for (Future future : futureList) {
            future.get();
        }
    }
}
