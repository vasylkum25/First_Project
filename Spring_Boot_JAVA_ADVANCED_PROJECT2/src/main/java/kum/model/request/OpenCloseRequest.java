package kum.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import kum.validation.anotation.UniqueOpenClose;

public class OpenCloseRequest {
	
	private Integer id;
	
	@UniqueOpenClose(message="Такий час вже є в БД")
	@NotBlank(message="Це поле не може бути пустим.")
	@Pattern(regexp = "^[0-2][0-9]:[0-5]{1}[0-9]$", message="Введенні дані не задовільняють формату")
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
