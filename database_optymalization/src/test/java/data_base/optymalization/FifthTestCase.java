package data_base.optymalization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;
import users.Admin;
import users.Moderator;
import users.User;

public class FifthTestCase extends TestCase {	
	
	/*public void setUp() throws Exception {
        super.setUp();
        creating_data.DeleteAll.removeAll();
        creating_data.AddingAuthors.addingAuthors();
        creating_data.AddingCompany.addingCompany();
        creating_data.AddingBooks.addingBooks();
        creating_data.AddingUsers.addingUsers();
        creating_data.AddingOrders.addingOrders();

    }*/
	
    List<String> cities =  new ArrayList<String>(
            Arrays.asList("Warsaw", "Manchester"));
    public void testRandom() {
        Random r=new Random();
        for(int i = 0; i<2000; i++){
            double random =  r.nextInt(100);
            if(random <= 70) {
                generateUserAction(i);
            } else if(random > 70 && random < 90) {
                generateModeratorAction();
            } else {
                generateAdminAction();
            }
        }
    }

    private void generateAdminAction() {
        Random r=new Random();
        Admin admin = new Admin();
        double year = r.nextInt(100) + 1900;
        admin.deleteBooksByYear((int)year,0);
    }

    private void generateModeratorAction() {
        Moderator moderator = new Moderator();
        Random r=new Random();
        int randomNumber=r.nextInt(cities.size());
        int randomNumber2=r.nextInt(cities.size());
        moderator.updateCity(cities.get(randomNumber),cities.get(randomNumber2));
    }

    private void generateUserAction(int i) {
        Random r=new Random();
        double v = r.nextInt(100);
        User user = new User(Integer.toString(i));
        if (v<50){
            user.findAllBooks(0);
        } else if (v<50 && v>75) {
            double year = r.nextInt(100) + 1900;
            user.findBooksOlderThan((int)year,0);
        } else {
            int randomNumber=r.nextInt(cities.size());
            user.findByCity(cities.get(randomNumber));
        }
    }
}
