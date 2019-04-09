package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class BooksEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) comment 'indetyfikator książki'")
	private Integer id;
	@Column(columnDefinition = "varchar2(50) comment 'tytuł książki'")
	private String title;
	@Column(columnDefinition = "varchar2(50) comment 'rok wydanie'")
	private int year;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return new BooksItem(title, year);
	}
	
}
