package repository.model;

import java.util.Date;

public class OrdersItem {

	private Date date_hire;
	private Date date_return;
	private boolean debt;
	
	public OrdersItem() {
	}

	public OrdersItem(Date date_hire, Date date_return, boolean debt) {
		this.date_hire = date_hire;
		this.date_return = date_return;
		this.debt = debt;
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
