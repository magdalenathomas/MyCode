package repository.model;

public class CompanyItem {

	private String city;
	private int id_company;

	public CompanyItem() {
	}

	public CompanyItem(int id_company, String city) {
		this.id_company = id_company;
		this.city = city;
	}

	public int getId_company() {
		return id_company;
	}

	public void setId_company(int id_company) {
		this.id_company = id_company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
