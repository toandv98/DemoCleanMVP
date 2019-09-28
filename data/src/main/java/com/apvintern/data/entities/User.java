package com.apvintern.data.entities;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class User {

    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private String company;

    @SerializedName("id")
    private String id;

    @SerializedName("email")
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