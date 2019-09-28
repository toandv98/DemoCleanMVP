package com.apvintern.data.utils;

import com.apvintern.data.api.ApiService;
import com.apvintern.data.api.RetrofitClient;

import static com.apvintern.data.utils.Constants.API_URL;

public class ApiUtils {
    public static ApiService getApiService() {
        return RetrofitClient.getClient(API_URL).create(ApiService.class);
    }
}
