package repository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class CompanyEntity {
	@Id
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Company_id_company")
	private List<BooksEntity> id_books;
	@Column(columnDefinition = "int(11) comment 'indetyfikator wydawnictwa'")
	private Integer id_company;
	@Column(columnDefinition = "varchar2(50) comment 'miejscowosc'")
	private String city;

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
