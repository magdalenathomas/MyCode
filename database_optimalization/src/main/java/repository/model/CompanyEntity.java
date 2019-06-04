package repository.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Company")
public class CompanyEntity {
	@Id
	@Column
	@GenericGenerator(name="company" , strategy="increment")
	@GeneratedValue(generator="company")
	private Integer id_company;
	@Column
	private String city;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyEntity")
	private List<BooksEntity> id_books;

	public Integer getId_company() {
		return id_company;
	}

	public void setId_company(Integer id_company) {
		this.id_company = id_company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CompanyItem getCompanyItem() {
		return new CompanyItem(id_company, city);
	}
}
