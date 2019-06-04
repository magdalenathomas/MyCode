package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;
import repository.JPA;
import repository.model.UsersItem;

import java.util.ArrayList;
import java.util.List;

public class AddingUsers {
	public static void addingUsers() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		List<UsersItem> users = new ArrayList<UsersItem>();
		for (int i = 1; i < 5000; i++) {
			int id_users = i;
			String user_name = df.getFirstName();
			String user_surname = df.getLastName();
			String user_mejl = df.getEmailAddress();
			int user_telephone = df.getNumberBetween(111111111, 999999999);
			UsersItem user = new UsersItem(id_users, user_name, user_surname, user_mejl, user_telephone);
			users.add(user);
		}
		repo.save(users);
	}
}