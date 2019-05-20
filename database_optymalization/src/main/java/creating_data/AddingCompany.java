package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;
import repository.CompanyRepository;
import repository.JPA;
import repository.model.CompanyItem;

public class AddingCompany {

	public static void addingCompany() throws Exception {

		JPA repo = null;
		repo = new JPA();
		CompanyRepository companyRepository = new CompanyRepository();

		DataFactory df = new DataFactory();
		for (int i = 1; i < 300; i++) {
			int id_company = i;
			String city = df.getCity();
			CompanyItem company = new CompanyItem(id_company, city);
			companyRepository.save(company);
		}
	}
}
