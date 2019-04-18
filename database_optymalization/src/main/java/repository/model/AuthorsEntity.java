package repository.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Authors")
public class AuthorsEntity {
	@Id
	@Column
	private int id_authors;
	@Column
	private String author_name;
	@Column
	private String author_surname;
	
	@ManyToMany(mappedBy = "authorsEntity", cascade =
			{CascadeType.PERSIST, CascadeType.MERGE})
	Set<BooksEntity> booksEntity = new HashSet<BooksEntity>();

	public int getId_authors() {
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

	public Set<BooksEntity> getBooksEntity() {
		return booksEntity;
	}

	public void setBooksEntity(Set<BooksEntity> booksEntity) {
		this.booksEntity = booksEntity;
	}
}
