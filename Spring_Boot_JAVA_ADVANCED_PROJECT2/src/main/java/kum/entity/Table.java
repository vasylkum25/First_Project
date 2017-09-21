package kum.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity{

	private int countOfPeople;
	
	private boolean isFree;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cafe cafe;
	
	

	public Table(int countOfPeople, boolean isFree, Cafe cafe) {
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.cafe = cafe;
	}

	public Table() {
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
