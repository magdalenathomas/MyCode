package repository.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class OrdersEntity {

	@Id
	@Column
	private Integer id_order;
	@Column
	private Date date_hire;
	@Column
	private Date date_return;
	@Column
	private boolean debt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Users_Id_Users")
	UsersEntity usersEntity;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "Orders_Books",
			joinColumns = { @JoinColumn(name = "orders_id_orders") },
			inverseJoinColumns = { @JoinColumn(name = "books_id_books") }
	)
	private Set<BooksEntity> booksEntity = new HashSet<BooksEntity>();

	public Integer getId_order() {
		return id_order;
	}

	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}

	public Date getDate_hire() {
		return date_hire;
	}

	public void setDate_hire(Date date_hire) {
		this.date_hire = date_hire;
	}

	public Date getDate_return() {
		return date_return;
	}

	public void setDate_return(Date date_return) {
		this.date_return = date_return;
	}

	public boolean isDebt() {
		return debt;
	}

	public void setDebt(boolean debt) {
		this.debt = debt;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public Set<BooksEntity> getBooksEntity() {
		return booksEntity;
	}

	public void setBooksEntity(Set<BooksEntity> booksEntity) {
		this.booksEntity = booksEntity;
	}

/*	public OrdersItem getOrdersItem() {
		return new OrdersItem(id_order, date_hire, date_return, debt);
	}*/
}
