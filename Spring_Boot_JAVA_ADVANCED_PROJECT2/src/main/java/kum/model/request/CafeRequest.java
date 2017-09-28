package kum.model.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import kum.entity.Meal;
import kum.entity.OpenClose;
import kum.validation.flag.CafeFlag;

public class CafeRequest {

	private Integer id;
	
	@Pattern(regexp = "^[A-Z][A-Za-z0-9]+| *$", groups=CafeFlag.class, message="Це поле не може починатися з малої букви")
	@NotBlank(message="Це поле не може бути пустим", groups=CafeFlag.class)
	private String name;
	
	private BigDecimal rate;
	
	private String photoUrl;

	private int version;
	
	private String address;
	
	private String shortDescription;
	
	private String fullDescription;
	
	private String type;
	
	@Pattern(regexp = "^\\+{1}[0-9]{12}$", message="Невірний формат (+38)", groups= CafeFlag.class)
	private String phone;
	
	@NotBlank(message="Це поле не може бути пустим", groups=CafeFlag.class)
	@Email(message="Невірний формат", groups=CafeFlag.class)
	private String web;
	
	private OpenClose open;

	private OpenClose close;
		
	private List<Meal> meals = new ArrayList<>();

	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public OpenClose getOpen() {
		return open;
	}

	public void setOpen(OpenClose open) {
		this.open = open;
	}

	public OpenClose getClose() {
		return close;
	}

	public void setClose(OpenClose close) {
		this.close = close;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
		
	
}
