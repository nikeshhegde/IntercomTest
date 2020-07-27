package com.nikesh.intercomhometest.model;


import java.io.Serializable;
/**
 * Model class of Customer to hold the JSON Data
 * @author nhegd 
 *
 */

public class Customer implements Serializable {
	
	//default serialVersion id
    private static final long serialVersionUID = 1L;
    		
	private int userId;
	private String name;
	private double latitude;
	private double longitude;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Customer(){
		
	}
	
	public Customer(int userId, String userName, double lat, double longitude) {
		this.userId = userId;
		this.name = userName;
		this.latitude = lat;
		this.longitude=longitude;
		
	}

	 @Override
	    public String toString(){
		 return new StringBuffer(" User Id: ").append(userId)
	                .append(" Full Name : ").append(name).toString();
	    }
	
}
