package kum.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="meal")
public class Meal extends AbstractEntity {

	private String title;
	
	@Column(length=1023)
	private String description;
	
	private BigDecimal price;
	
	private String photoUrl;
	
	private int version;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cuisine cuisine;
	
	private int weight;
	
	@ManyToMany
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@ManyToMany(mappedBy = "meals")
	private List<Order> orders = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private Cafe cafe; 
	
	@OneToMany(mappedBy = "meal")
	private List<Comment> comments = new ArrayList<>();
	
	public Meal() {
	}

	

	public Meal(String title, String description, BigDecimal price, Cuisine cuisine, int weight,
			List<Ingredient> ingredients, Cafe cafe) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.cuisine = cuisine;
		this.weight = weight;
		this.ingredients = ingredients;
		this.cafe = cafe;
	}



	public String getTitle() {
		return title;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Meal [title=" + title + ", description=" + description + ", price=" + price + ", cuisine=" + cuisine.getName()
				+ ", weight=" + weight + ", orders=" + orders + ", cafe=" + cafe + "]";
	}
	
}
