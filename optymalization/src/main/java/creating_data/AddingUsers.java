package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.UsersItem;

public class AddingUsers {
	public static void addingUsers() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		for (int i = 0; i < 100; i++) {
			int id_users = i;
			String user_name = df.getFirstName();
			String user_surname = df.getLastName();
			String user_mejl = df.getEmailAddress();
			int user_telephone = df.getNumberBetween(111111111, 999999999);
			UsersItem user = new UsersItem(id_users, user_name, user_surname, user_mejl, user_telephone);
			repo.save(user);
		}
	}
}
