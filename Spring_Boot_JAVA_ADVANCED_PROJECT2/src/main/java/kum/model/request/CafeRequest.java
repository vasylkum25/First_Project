package kum.model.request;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import kum.entity.Meal;
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
	
	private LocalTime open;

	private LocalTime close;
		
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

	public LocalTime getOpen() {
		return open;
	}

	public void setOpen(LocalTime open) {
		this.open = open;
	}

	public LocalTime getClose() {
		return close;
	}

	public void setClose(LocalTime close) {
		this.close = close;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CafeRequest other = (CafeRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
	
}
