package creating_data;

import org.fluttercode.datafactory.impl.DataFactory;
import repository.CompanyRepository;
import repository.JPA;
import repository.model.CompanyItem;

import java.util.ArrayList;
import java.util.List;

public class AddingCompany {

	public static void addingCompany() throws Exception {

		JPA repo = null;
		repo = new JPA();
		CompanyRepository companyRepository = new CompanyRepository();
		List<CompanyItem> companies = new ArrayList<CompanyItem>();
		DataFactory df = new DataFactory();
		for (int i = 1; i < 5000; i++) {
			int id_company = i;
			String city = df.getCity();
			CompanyItem company = new CompanyItem(id_company, city);
			companies.add(company);

		}
		companyRepository.save(companies);
	}
}
