package kum.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity{

	private int countOfPeople;
	
	private boolean isFree;
	
	private String number;
	
	private String name;
	
	private int totalPrice;
	
	private String phone;
	@ManyToOne(fetch = FetchType.LAZY)
	private Cafe cafe;
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
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

	
	

	public Table(int countOfPeople, boolean isFree, Cafe cafe, String number) {
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.cafe = cafe;
		this.number = number;
	}

	public Table() {
	}

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
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
