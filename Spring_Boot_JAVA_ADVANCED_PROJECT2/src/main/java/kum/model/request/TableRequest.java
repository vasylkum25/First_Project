package kum.model.request;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import kum.entity.Cafe;

public class TableRequest {

	private Integer id;

	private Integer countOfPeople;
	
	private boolean isFree;
	
	private Cafe cafe;
	
	private String number;
	
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public Integer getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(Integer countOfPeople) {
		this.countOfPeople = countOfPeople;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
}
