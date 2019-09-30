package com.apvintern.domain.entities;

public class User {

    private String name;

    private int id;

    private String email;

    public User(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return
                "UserResponse{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}
