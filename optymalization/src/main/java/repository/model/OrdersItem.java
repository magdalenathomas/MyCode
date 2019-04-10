package repository.model;

import java.util.Date;

public class OrdersItem {

	private Date date_hire;
	private Date date_return;
	private boolean debt;
	private int id_order;
	
	public OrdersItem() {
	}

	public OrdersItem(int id_order, Date date_hire, Date date_return, boolean debt) {
		this.id_order = id_order;
		this.date_hire = date_hire;
		this.date_return = date_return;
		this.debt = debt;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
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
}
