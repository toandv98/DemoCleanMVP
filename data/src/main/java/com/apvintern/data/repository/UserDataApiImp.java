package com.apvintern.data.repository;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.data.retrofit.ApiService;
import com.apvintern.data.retrofit.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataApiImp implements UserDataApi {

    private ApiService apiService;

    public UserDataApiImp() {
        this.apiService = ApiUtils.getApiService();
    }

    @Override
    public void getUsers(UsersDataCallBack usersDataCallBack) {
        apiService.getUsers().enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (response.isSuccessful()) {
                    usersDataCallBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable throwable) {
                usersDataCallBack.onFailure(throwable.getMessage());
            }
        });
    }

    @Override
    public void getUserById(int id, UserDataCallBack userDataCallBack) {
        apiService.getUserById(id).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                userDataCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable throwable) {
                userDataCallBack.onFailure(throwable.getMessage());
            }
        });
    }

    @Override
    public void addUser(UserResponse userResponse, UserDataCallBack userDataCallBack) {
        apiService.addUser(userResponse).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void deleteUser(int id, UserDataCallBack userDataCallBack) {
        apiService.deleteUser(id).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable throwable) {

            }
        });
    }
}
