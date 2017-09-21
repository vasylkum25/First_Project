package kum.model.view;

import java.time.LocalDate;


public class UserView {

	private Integer id;
	
	private String name;
	
	private String login;
	
	private String password;
	
	private String photoUrl;
	
	private String lastName;
	
	private LocalDate birthday;
	
	private int version;
	
	private String phone; 

	private String email;
	

	public UserView(Integer id, String name, String login, String password, String lastName, String phone, String email) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
