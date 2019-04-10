package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;

import repository.JPA;
import repository.model.CompanyItem;

public class AddingCompany {

	public static void addingCompany() throws Exception {

		JPA repo = null;
		repo = new JPA();

		DataFactory df = new DataFactory();
		for (int i = 0; i < 50; i++) {
			int id_company = i;
			String city = df.getCity();
			CompanyItem company = new CompanyItem(id_company, city);
			repo.save(company);
		}
	}
}
