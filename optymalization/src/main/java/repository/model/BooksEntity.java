package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class BooksEntity {
	@Id
	@Column(columnDefinition = "int(11) comment 'indetyfikator książki'")
	private Integer id_books;
	@Column(columnDefinition = "varchar2(50) comment 'tytuł książki'")
	private String title;
	@Column(columnDefinition = "varchar2(50) comment 'rok wydanie'")
	private int year;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
	CompanyEntity companyEntity;
	

	public Integer getId_books() {
		return id_books;
	}
	public void setId_books(Integer id_books) {
		this.id_books = id_books;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public BooksItem getBooksItem() {
		return new BooksItem(id_books, title, year);
	}
	
}
