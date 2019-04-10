package repository.model;

public class AuthorsItem {

	private String author_surname;
	private String author_name;
	private int id_authors;

	public AuthorsItem() {
	}

	public AuthorsItem(int id_authors, String author_name, String author_surname) {
		this.id_authors = id_authors;
		this.author_name = author_name;
		this.author_surname = author_surname;
	}

	public int getId_authors() {
		return id_authors;
	}

	public void setId_authors(int id_authors) {
		this.id_authors = id_authors;
	}

	public String getAuthor_surname() {
		return author_surname;
	}

	public void setAuthor_surname(String author_surname) {
		this.author_surname = author_surname;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

}
