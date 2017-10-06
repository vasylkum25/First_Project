package kum.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommentView {
	
	private Integer id;
	
	private String message;
	
	private String time;
	
	private BigDecimal rate;
	
	private String user;
	
	private List<CommentView> childComment;

	
	public CommentView() {
	}

	public CommentView(Integer id, String message, LocalDateTime time, BigDecimal rate, String user) {
		this.message = message;
		this.time = time==null ? null : time.format(DateTimeFormatter.ofPattern("yyyy/M/d h:mm a"));
		this.rate = rate;
		this.user = user;
		this.id = id;
	}

	
	public List<CommentView> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<CommentView> childComment) {
		this.childComment = childComment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	
	
	
}
