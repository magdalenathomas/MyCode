package repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class UsersEntity {
	@Id
	@Column
	private Integer id_users;
	@Column
	private String user_name;
	@Column
	private String user_surname;
	@Column
	private String user_mejl;
	@Column
	private int user_telephone;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersEntity")
	private List<UsersEntity> usersEntity;

	public Integer getId_users() {
		return id_users;
	}
	public void setId_users(Integer id_users) {
		this.id_users = id_users;
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
	
	/*public UsersItem getUsersItem() {
		return new UsersItem(id_users, user_name, user_surname, user_mejl, user_telephone);
	}*/

	public List<UsersEntity> getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(List<UsersEntity> usersEntity) {
		this.usersEntity = usersEntity;
	}
}
