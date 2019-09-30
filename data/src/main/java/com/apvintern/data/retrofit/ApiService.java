package com.apvintern.data.retrofit;

import com.apvintern.data.entities.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/v1/users")
    Call<List<UserResponse>> getUsers();

    @GET("/api/v1/users/{id}")
    Call<UserResponse> getUserById(@Path("id") int id);

    @POST("/api/users")
    Call<UserResponse> addUser(@Body UserResponse user);

    @DELETE("/api/users/{id}")
    Call<UserResponse> deleteUser(@Path("id") int id);
}
