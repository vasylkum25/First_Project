package kum.model.request;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class ReserveRequest {

	@NotBlank(message="Це поле обов'язкове до заповнення")
	private String name;
	
	@Pattern(regexp = "^\\+{1}[0-9]{12}$", message="Введений не вірний формат")
	private String phone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
