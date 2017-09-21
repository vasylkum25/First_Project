package kum.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment extends AbstractEntity {

	@Lob
	private String message;
	
	private LocalDateTime time;
	
	private int _like;
	
	private int _disLike;
	
	
	private String user;
	
	private BigDecimal rate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cafe cafe;
	
	@ManyToOne
	private Comment parentComent;
	
	@OneToMany(mappedBy = "parentComent")
	private List<Comment> childComment = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Meal meal;

	
	
	public Comment() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Comment getParentComent() {
		return parentComent;
	}

	public void setParentComent(Comment parentComent) {
		this.parentComent = parentComent;
	}

	public List<Comment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<Comment> childComment) {
		this.childComment = childComment;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int get_like() {
		return _like;
	}

	public void set_like(int _like) {
		this._like = _like;
	}

	public int get_disLike() {
		return _disLike;
	}

	public void set_disLike(int _disLike) {
		this._disLike = _disLike;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
	
}
