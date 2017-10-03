package kum.model.filter;

import java.util.regex.Pattern;


public class SimpleFilter {
	
	private static final Pattern TIME_PATTERN = Pattern.compile("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
	
	private String search="";

	private String searchOpen="";
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchOpen() {
		return searchOpen;
	}

	public void setSearchOpen(String searchOpen) {
		if(TIME_PATTERN.matcher(searchOpen).matches())
		this.searchOpen = searchOpen;
	}
	
	

}
