package com.beer.business;

import javax.persistence.*;

@Entity
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int breweryID;
	private String name;
	private String style;
	private double ABV;
	private double IBU;
	private double rating;

	public Beer() {
		super();
	}

	public Beer(int id, int breweryID, String name, String style, double aBV, double iBU, double rating) {
		super();
		this.id = id;
		this.breweryID = breweryID;
		this.name = name;
		this.style = style;
		ABV = aBV;
		IBU = iBU;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBreweryID() {
		return breweryID;
	}

	public void setBreweryID(int breweryID) {
		this.breweryID = breweryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getABV() {
		return ABV;
	}

	public void setABV(double aBV) {
		ABV = aBV;
	}

	public double getIBU() {
		return IBU;
	}

	public void setIBU(double iBU) {
		IBU = iBU;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", breweryID=" + breweryID + ", name=" + name + ", style=" + style + ", ABV=" + ABV
				+ ", IBU=" + IBU + ", rating=" + rating + "]";
	}

}
