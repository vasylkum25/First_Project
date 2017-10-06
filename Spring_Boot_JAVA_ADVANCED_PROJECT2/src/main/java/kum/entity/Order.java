package kum.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_order")
public class Order extends AbstractEntity{

	@ManyToMany
	private List<Meal> meals = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private kum.entity.Table table;

	private BigDecimal totalPrice;
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public List<Meal> getMeals() {
		return meals;
	}


	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}


	public kum.entity.Table getTable() {
		return table;
	}


	public void setTable(kum.entity.Table table) {
		this.table = table;
	}
	
	
}
