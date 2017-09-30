package kum.model.filter;

import javax.validation.constraints.Pattern;

import kum.validation.flag.OpenCloseFlag;

public class SimpleFilter {
	
	@Pattern(regexp = "^[0-2][0-3]:[0-5]{1}[0-9]$", message="Введенні дані не задовільняють формату", groups={OpenCloseFlag.class})
	private String search="";

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	

}
