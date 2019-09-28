package com.apvintern.domain.model;

public class UserModel {

    private String name;

    private String company;

    private String id;

    private String email;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "name = '" + name + '\'' +
                        ",company = '" + company + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}
