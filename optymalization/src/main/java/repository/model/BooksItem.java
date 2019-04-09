package repository.model;

public class BooksItem {

	private String title;
	private int year;

	public BooksItem() {
	}

	public BooksItem(String title, int year) {
		this.title = title;
		this.year = year;
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
