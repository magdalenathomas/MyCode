package data_base.optymalization;

import junit.framework.TestCase;
import users.Moderator;
import users.User;

public class SecondTestCase extends TestCase {

    final static int NUMBER_OF_USERS = 4000;
    static String oldCity = "Warsaw";
    static String newCity = "Manchester";
    
    /*public void setUp() throws Exception {
        super.setUp();
        creating_data.DeleteAll.removeAll();
        creating_data.AddingAuthors.addingAuthors();
        creating_data.AddingCompany.addingCompany();
        creating_data.AddingBooks.addingBooks();
        creating_data.AddingUsers.addingUsers();
        creating_data.AddingOrders.addingOrders();

    }*/

    public void testChangeName(){
        for(int i=0; i<NUMBER_OF_USERS; i++) {
            if(i==NUMBER_OF_USERS/2) {
                Moderator moderator = new Moderator();
                System.out.println("Zmieniam nazwe");
                moderator.updateCity(oldCity, newCity);
            }
            User user = new User(Integer.toString(i));
            user.findByCity(newCity);
        }

    }
}
