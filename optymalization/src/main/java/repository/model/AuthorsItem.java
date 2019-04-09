package repository.model;

public class AuthorsItem {

	private String author_surname;
	private String author_name;

	public AuthorsItem() {
	}

	public AuthorsItem(String author_name, String author_surname) {
		this.author_name = author_name;
		this.author_surname = author_surname;
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
