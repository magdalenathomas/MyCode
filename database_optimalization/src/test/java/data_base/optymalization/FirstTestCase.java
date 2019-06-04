package data_base.optymalization;

import junit.framework.TestCase;
import users.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FirstTestCase extends TestCase {

    int YEAR_TO_DELETE = 1990;
    public void testfirst() throws InterruptedException, ExecutionException {
        List<Future> futureList = new ArrayList<Future>();
        for(int i = 0; i < 20; i++) {
            Admin admin = new Admin();
            futureList.add(admin.deleteBook());
        }
        for (Future future : futureList) {
            future.get();
        }
    }

    public void testsecond() throws InterruptedException, ExecutionException {
        List<Future> futureList = new ArrayList<Future>();
        for(int i = 0; i < 20; i++) {
            Admin admin = new Admin();
            futureList.add(admin.deleteBookByYear(YEAR_TO_DELETE,0));
        }

        for (Future future : futureList) {
            future.get();
        }
    }
}
