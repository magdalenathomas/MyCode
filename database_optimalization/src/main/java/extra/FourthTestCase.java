package extra;

import junit.framework.TestCase;
import users.Admin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by U118788 on 5/16/2019.
 */
public class FourthTestCase extends TestCase{

    public void testAuthorChange() throws ExecutionException, InterruptedException {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Future future = admin1.updateAuthor(1, 2);
        admin2.updateAuthor(2,3);
        future.get();

    }

}
