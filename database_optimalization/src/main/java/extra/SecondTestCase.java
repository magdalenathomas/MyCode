package extra;

import junit.framework.TestCase;
import users.Moderator;
import users.User;

/**
 * Created by U118788 on 5/16/2019.
 */
public class SecondTestCase extends TestCase {
    final static int NUMBER_OF_USERS = 10;
    static String oldCity = "Manchester";
    static String newCity = "Warsaw";

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
