package com.example.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class IconFilterDTO {
	private String name;
	private String date;
	private List<Long> cities;
	private String order;
	
	
	public IconFilterDTO(String name, String date, List<Long> cities, String order) {
		this.name = name;
		this.date = date;
		this.cities = cities;
		this.order = order;
	}
	
	public boolean isAsc() {
		return order.compareToIgnoreCase("ASC")==0;
	}
	
	
}
