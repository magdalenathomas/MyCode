package repository.model;

import java.util.Set;

public class BooksItem {

	private String title;
	private int year;
	private int id_books;
	CompanyEntity companyEntity;
	Set<AuthorsEntity> authorsEntitySet;
	public BooksItem() {
	}

	public BooksItem(int id_books, String title, int year, CompanyEntity companyEntity, Set<AuthorsEntity> authorsEntitySet) {
		this.id_books = id_books;
		this.title = title;
		this.year = year;
		this.companyEntity = companyEntity;
		this.authorsEntitySet = authorsEntitySet;
	}

	public int getId_books() {
		return id_books;
	}

	public void setId_books(int id_books) {
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

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	public Set<AuthorsEntity> getAuthorsEntitySet() {
		return authorsEntitySet;
	}

	public void setAuthorsEntitySet(Set<AuthorsEntity> authorsEntitySet) {
		this.authorsEntitySet = authorsEntitySet;
	}
}
