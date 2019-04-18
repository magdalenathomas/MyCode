package repository.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
public class BooksEntity {
	@Id
	@Column
	private Integer id_books;
	@Column
	private String title;
	@Column
	private int year;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Company_Id_Company")
	CompanyEntity companyEntity;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "Books_Authors",
			joinColumns = { @JoinColumn(name = "books_id_books") },
			inverseJoinColumns = { @JoinColumn(name = "authors_id_authors") }
	)
	private Set<AuthorsEntity> authorsEntity = new HashSet<AuthorsEntity>();

	@ManyToMany(mappedBy = "booksEntity", cascade =
			{CascadeType.PERSIST, CascadeType.MERGE})
	Set<OrdersEntity> ordersEntity = new HashSet<OrdersEntity>();

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
		return new BooksItem(id_books, title, year, companyEntity, authorsEntity);
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	public Set<AuthorsEntity> getAuthorsEntity() {
		return authorsEntity;
	}

	public void setAuthorsEntity(Set<AuthorsEntity> authorsEntity) {
		this.authorsEntity = authorsEntity;
	}

	public Set<OrdersEntity> getOrdersEntity() {
		return ordersEntity;
	}

	public void setOrdersEntity(Set<OrdersEntity> ordersEntity) {
		this.ordersEntity = ordersEntity;
	}
}
