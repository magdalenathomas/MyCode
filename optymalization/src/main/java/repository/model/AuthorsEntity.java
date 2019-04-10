package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class AuthorsEntity {
	@Id
	@Column(columnDefinition = "int(11) comment 'indetyfikator autora'")
	private Integer id_authors;
	@Column(columnDefinition = "varchar2(50) comment 'imię autora'")
	private String author_name;
	@Column(columnDefinition = "varchar2(50) comment 'nazwisko autora'")
	private String author_surname;

	public Integer getId_authors() {
		return id_authors;
	}

	public void setId_authors(Integer id_authors) {
		this.id_authors = id_authors;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_surname() {
		return author_surname;
	}

	public void setAuthor_surname(String author_surname) {
		this.author_surname = author_surname;
	}

	public AuthorsItem getAuthorsItem() {
		return new AuthorsItem(id_authors, author_name, author_surname);
	}
}
