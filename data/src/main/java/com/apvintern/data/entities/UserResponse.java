package com.apvintern.data.entities;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("company")
	private String company;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("longitude")
	private String longitude;

	public UserResponse(String latitude, String name, String company, String email, String longitude) {
		this.latitude = latitude;
		this.name = name;
		this.company = company;
		this.email = email;
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return
				"UserResponse{" +
						"latitude = '" + latitude + '\'' +
						",name = '" + name + '\'' +
						",company = '" + company + '\'' +
						",id = '" + id + '\'' +
						",email = '" + email + '\'' +
						",longitude = '" + longitude + '\'' +
						"}";
	}
}