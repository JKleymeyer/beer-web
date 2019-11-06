package com.beer.business;

import javax.persistence.*;

@Entity
public class Brewery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private String state;
	private double rating;
	
	public Brewery() {
		super();
	}

	public Brewery(int id, String name, String city, String state, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.rating = rating;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Brewery [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", rating=" + rating
				+ "]";
	}
	

}
