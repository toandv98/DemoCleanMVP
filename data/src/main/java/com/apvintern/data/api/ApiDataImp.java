package com.apvintern.data.api;

import com.apvintern.data.entities.User;
import com.apvintern.data.utils.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiDataImp implements ApiData {

    private ApiService apiService;

    public ApiDataImp() {
        this.apiService = ApiUtils.getApiService();
    }

    @Override
    public void getUsers(DataCallBack dataCallBack) {
        apiService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                dataCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                dataCallBack.onFailure(throwable.getMessage());
            }
        });
    }
}
