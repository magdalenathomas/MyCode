package data_base.optymalization;

import junit.framework.TestCase;
import users.Admin;
import users.Moderator;
import users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimulateUsersTestCase extends TestCase{
    List<Future> futureList = new ArrayList<Future>();
    String[] cities = {
            "Mcrae",
            "Millen",
            "Marietta",
            "Everitt",
            "Edith",
            "Chauncey",
            "Sunsweet",
            "Blue Ridge",
            "Hartwell",
            "Woodstock",
            "Toomsboro",
            "Culloden",
            "Adairsville",
            "New Rock Hill",
            "Geneva",
            "Retreat",
            "Conyers",
            "Remerton",
            "Axson",
            "Montrose",
            "Egypt",
            "Tybee Island",
            "Montrose",
            "Kennesaw",
            "Buford",
            "Westwood"
    };


    public void testSimulation() throws ExecutionException, InterruptedException {
        for(int i = 0; i < 50; i++) {
            int probability = new Random().nextInt(10);
            int delay = new Random().nextInt(5000);
            if(probability > 8) {
                futureList.add(adminAction(delay));
            } else if(probability >5) {
                futureList.add(moderatorAction(delay));
            } else {
                futureList.add(userAction(delay));
            }
        }
        for (Future future : futureList) {
            future.get();
        }
    }

    private Future userAction(int delay) {
        User user = new User("name");
        return user.findBookByAuthor();
    }

    private Future moderatorAction(int delay) {
        Moderator moderator = new Moderator();
        String oldC = cities[new Random().nextInt(cities.length)];
        String newC = cities[new Random().nextInt(cities.length)];
        return moderator.updateCity(oldC,newC, delay);
    }

    private Future adminAction(int delay) {
        Admin admin = new Admin();
        int year = new Random().nextInt(10) + 1960;
        return admin.deleteBookByYear(year, delay);
    }
}
