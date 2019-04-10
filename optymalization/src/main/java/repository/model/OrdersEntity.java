package repository.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrdersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) comment 'indetyfikator zamówienia'")
	private Integer id_order;
	@Column(columnDefinition = "date comment 'data wypożyczenia'")
	private Date date_hire;
	@Column(columnDefinition = "date comment 'data zwrotu'")
	private Date date_return;
	@Column(columnDefinition = "char(1) comment 'zadłużenie'")
	private boolean debt;

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
	
	public OrdersItem getOrdersItem() {
		return new OrdersItem(id_order, date_hire, date_return, debt);
	}
}
