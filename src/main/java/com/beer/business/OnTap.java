package com.beer.business;

import javax.persistence.*;

@Entity
public class OnTap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="VenueId")
	private Venue venue;
	@ManyToOne
	@JoinColumn(name="beerId")
	private Beer beer;

	public OnTap() {
		super();
	}

	public OnTap(int id, Venue venue, Beer beer) {
		super();
		this.id = id;
		this.venue = venue;
		this.beer = beer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	@Override
	public String toString() {
		return "OnTap [id=" + id + ", venue=" + venue + ", beer=" + beer + "]";
	}

}
