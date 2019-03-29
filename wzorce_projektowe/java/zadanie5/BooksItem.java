package zadanie5;

import java.util.Date;

public class BooksItem {

	private String title;
	private String author;
	private Date releaseDate;
	private int quantity;
	
	public BooksItem(String title, String author, Date releaseDate, int quantity) {
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public int getQuantity() {
		return quantity;
	}
	
}
