package kum.model.view;

import java.math.BigDecimal;
import java.util.List;

import kum.entity.Cafe;
import kum.entity.Cuisine;

public class MealView {

	
	private Integer id;
	
	private String title;
	
	private String description;
	
	private BigDecimal price;
	
	private String photoUrl;
	
	private int version;
	
	private String cuisine;
	
	private int weight;
	
	private String cafe;
	
	private List<String> ingredients;

	
	public MealView() {
	}
	
	public MealView(Integer id, String title, String description, BigDecimal price, String photoUrl, int version, String cuisine, int weight) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.photoUrl = photoUrl;
		this.version = version;
		this.cuisine = cuisine;
		this.weight = weight;
	}

	public MealView(Integer id, String title, String description, BigDecimal price, String photoUrl, int version,
			Cuisine cuisine, int weight, Cafe cafe) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.photoUrl = photoUrl;
		this.version = version;
		this.cuisine = cuisine.getName();
		this.weight = weight;
		this.cafe = cafe.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
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

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

}
