package com.wolken.wolkenapp.dto;

public class PrisonDTO {
	private int id ;
	private String name ;
	private String place;
	private int no_of_prisoners ;
	
	public  PrisonDTO() {
		
	};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getNo_of_prisoners() {
		return no_of_prisoners;
	}
	public void setNo_of_prisoners(int no_of_prisoners) {
		this.no_of_prisoners = no_of_prisoners;
	}
	
	

}
