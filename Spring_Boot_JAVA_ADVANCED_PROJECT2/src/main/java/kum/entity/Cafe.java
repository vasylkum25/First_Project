package kum.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="cafe")
public class Cafe extends AbstractEntityName {
	
	
	
	private BigDecimal rate;
	
	
	private String photoUrl;

	private int version;
	
	private String address;
	
	private String web;
	
	private String shortDescription;
	
	@Lob
	private String fullDescription;
	
	@Enumerated
	private Type type;
	
	@Column(length=13)
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private OpenClose open;
	@ManyToOne(fetch = FetchType.LAZY)
	private OpenClose close;
	
	@OneToMany(mappedBy="cafe")
	private List<kum.entity.Table> tables= new ArrayList<>();
	
	@OneToMany(mappedBy = "cafe")
	private List<Meal> meals = new ArrayList<>();
	
	@OneToMany(mappedBy="cafe")
	private List<Comment> comments = new ArrayList<>();
	
	
	public List<Meal> getMeals() {
		return meals;
		
	}
	
	public Cafe() {
	}

	public Cafe(String name, String address, String fullDescription, String phone, String email) {
		super(name);
		this.address = address;
		this.fullDescription = fullDescription;
		this.phone = phone;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	public String getWeb() {
		return web;
	}
	
	public void setWeb(String web) {
		this.web = web;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	public List<kum.entity.Table> getTables() {
		return tables;
	}
	public void setTables(List<kum.entity.Table> tables) {
		this.tables = tables;
	}
	

}
