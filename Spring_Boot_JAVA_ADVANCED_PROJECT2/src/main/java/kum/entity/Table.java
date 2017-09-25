package kum.entity;

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
	
	private int phone;
	@ManyToOne(fetch = FetchType.LAZY)
	private Cafe cafe;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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
