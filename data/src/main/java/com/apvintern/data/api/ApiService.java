package com.apvintern.data.api;

import com.apvintern.data.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/v1/users")
    Call<List<User>> getUsers();

    @POST("/api/users")
    Call<User> addUsers(@Body User users);

    @DELETE("/api/users/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
