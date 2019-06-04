package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;
import repository.BookRepository;
import repository.JPA;
import repository.model.BooksEntity;
import repository.model.OrdersItem;
import repository.model.UsersEntity;

import java.util.*;

public class AddingOrders {

	public static void addingOrders() throws Exception {

		JPA repo = null;
		repo = new JPA();
		BookRepository bookRepository = new BookRepository();

		DataFactory df = new DataFactory();

		Collection<BooksEntity> allBooks = bookRepository.findAll();
		Collection<UsersEntity> allUsers = repo.findAllUsers();

		boolean debt = false;
		for (int i = 1; i < 1000; i++) {
			int id_order = i;
			Date minDate = df.getDate(2015, 1, 1);
			Date maxDate = df.getDate(2016, 12, 31);
			Date date_hire = df.getDateBetween(minDate, maxDate);
			Date date_return = df.getDate(date_hire, 1, 60);
			UsersEntity usersEntity = df.getItem(new ArrayList<UsersEntity>(allUsers));
			Set<BooksEntity> booksEntityList = new HashSet<BooksEntity>();
			BooksEntity author = (BooksEntity) df.getItem(new ArrayList(allBooks));
			booksEntityList.add(author);
			for(int z = 0; z < 10; z++) {
				author = (BooksEntity) df.getItem(new ArrayList(allBooks), 10);
				if(author != null) {
					booksEntityList.add(author);
				}
			}
			/*
			 * if (date_return.getMonth() >= date_hire.getMonth()) { int wynik =
			 * (date_return.getDay() - date_hire.getDay()); if (wynik > 30) { debt = true; }
			 * else { debt = false; } }
			 */
			OrdersItem order = new OrdersItem(id_order, date_hire, date_return, debt, usersEntity, booksEntityList);
			repo.save(order);
		}
	}
}
