package kum.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentView {
	
	private String message;
	
	private String time;
	
	private BigDecimal rate;
	
	private String user;

	
	public CommentView() {
	}

	public CommentView(String message, LocalDateTime time, BigDecimal rate, String user) {
		this.message = message;
		this.time = time==null ? null : time.format(DateTimeFormatter.ofPattern("yyyy/M/d h:mm a"));
		this.rate = rate;
		this.user = user;
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
