package com.apvintern.domain.entities;

public class UserDetail {

    private String latitude;

    private String name;

    private String company;

    private int id;

    private String email;

    private String longitude;

    public UserDetail(String latitude, String name, String company, int id, String email, String longitude) {
        this.latitude = latitude;
        this.name = name;
        this.company = company;
        this.id = id;
        this.email = email;
        this.longitude = longitude;
    }

    public UserDetail(String latitude, String name, String company, String email, String longitude) {
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
