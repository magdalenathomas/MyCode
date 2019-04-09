package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class AuthorsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) comment 'indetyfikator autora'")
	private Integer id;
	@Column(columnDefinition = "varchar2(50) comment 'imię autora'")
	private String author_name;
	@Column(columnDefinition = "varchar2(50) comment 'nazwisko autora'")
	private String author_surname;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return new AuthorsItem(author_name, author_surname);
	}
}
