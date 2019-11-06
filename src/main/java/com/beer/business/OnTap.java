package com.beer.business;

import javax.persistence.*;

@Entity
public class OnTap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int venueID;
	private int beerID;

	public OnTap() {
		super();
	}

	public OnTap(int id, int venueID, int beerID) {
		super();
		this.id = id;
		this.venueID = venueID;
		this.beerID = beerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVenueID() {
		return venueID;
	}

	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}

	public int getBeerID() {
		return beerID;
	}

	public void setBeerID(int beerID) {
		this.beerID = beerID;
	}

	@Override
	public String toString() {
		return "OnTap [id=" + id + ", venueID=" + venueID + ", beerID=" + beerID + "]";
	}

}
