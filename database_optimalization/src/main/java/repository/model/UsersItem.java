package repository.model;

public class UsersItem {

	private String user_name;
	private String user_surname;
	private String user_mejl;
	private int user_telephone;
	private int id_users;

	public UsersItem() {
	}

	public UsersItem(int id_users, String user_name, String user_surname, String user_mejl, int user_telephone) {
		this.id_users = id_users;
		this.user_name = user_name;
		this.user_surname = user_surname;
		this.user_mejl = user_mejl;
		this.user_telephone = user_telephone;
	}

	public int getId_users() {
		return id_users;
	}

	public void setId_users(int id_users) {
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
}
