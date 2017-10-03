package kum.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MealFilter {

	private static final Pattern INT_PATTERN = Pattern.compile("^[0-9]{1,10}$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,5}\\.[0-9]{0,2})|([0-9]{1,5}\\,[0-9]{0,2})|([0-9]{1,5})$");

	private String minPrice = "";
	
	private String maxPrice = "";
	
	private List<String> cafeId = new ArrayList<>();
	
	private List<String> cuisineId = new ArrayList<>();
	
	private String search = "";

	public String getMinPrice() {
		return minPrice;
	}

	
	public List<String> getCuisineId() {
		return cuisineId;
	}


	public void setCuisineId(List<String> cuisineId) {
		this.cuisineId = cuisineId;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}

	public List<String> getCafeId() {
		return cafeId;
	}

	public void setCafeId(List<String> cafeId) {
		this.cafeId = cafeId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
}
