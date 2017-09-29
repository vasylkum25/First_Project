package kum.model.request;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import kum.entity.Cafe;
import kum.entity.Cuisine;
import kum.entity.Ingredient;

public class MealRequest {

	private Integer id;
	
	@Pattern(regexp = "^[A-Z][A-Za-z0-9]+| *$", message="Це поле не може починатися з малої букви")
	@NotBlank(message="Це поле не може бути пустим")
	private String title;
	
	private String description;
	
	private String price;
	
	private String photoUrl;
	
	private int version;
	
	private Cuisine cuisine;
	
	private Cafe cafe;
	
	private String weight;
	
	private List<Ingredient> ingredients;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
		
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
}
