package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) comment 'indetyfikator użytkownika'")
	private Integer id;
	@Column(columnDefinition = "varchar2(50) comment 'imię użytkownika'")
	private String user_name;
	@Column(columnDefinition = "varchar2(50) comment 'nazwisko użytkownika'")
	private String user_surname;
	@Column(columnDefinition = "varchar2(50) comment 'mejl użytkownika'")
	private String user_mejl;
	@Column(columnDefinition = "int(11) comment 'numer telefonu użytkownika'")
	private int user_telephone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_surname() {
		return user_surname;
	}
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}
	public String getUser_mejl() {
		return user_mejl;
	}
	public void setUser_mejl(String user_mejl) {
		this.user_mejl = user_mejl;
	}
	public int getUser_telephone() {
		return user_telephone;
	}
	public void setUser_telephone(int user_telephone) {
		this.user_telephone = user_telephone;
	}
	
	public UsersItem getUsersItem() {
		return new UsersItem(user_name, user_surname, user_mejl, user_telephone);
	}
}
