package creating_data;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.OrdersItem;

public class AddingOrders {

	public static void addingOrders() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		boolean debt = false;
		for (int i = 0; i < 100; i++) {
			Date minDate = df.getDate(2015, 1, 1);
			Date maxDate = df.getDate(2016, 12, 31);
			Date date_hire = df.getDateBetween(minDate, maxDate);
			Date date_return = df.getDate(date_hire, 1, 60);
			/*
			 * if (date_return.getMonth() >= date_hire.getMonth()) { int wynik =
			 * (date_return.getDay() - date_hire.getDay()); if (wynik > 30) { debt = true; }
			 * else { debt = false; } }
			 */
			OrdersItem order = new OrdersItem(date_hire, date_return, debt);
			repo.save(order);
		}
	}
}
