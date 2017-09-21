package kum.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class User extends AbstractEntity{
	
	private String email;
	
	private String password;
	
	private Role role;
	
	@OneToMany
	private List<Cafe> cafe = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Cafe> getCafe() {
		return cafe;
	}

	public void setCafe(List<Cafe> cafe) {
		this.cafe = cafe;
	}
	
	
	
}
