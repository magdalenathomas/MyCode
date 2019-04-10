package repository.model;

public class BooksItem {

	private String title;
	private int year;
	private int id_books;

	public BooksItem() {
	}

	public BooksItem(int id_books, String title, int year) {
		this.id_books = id_books;
		this.title = title;
		this.year = year;
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
}
