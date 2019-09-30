package com.apvintern.data.retrofit;

import static com.apvintern.data.utils.Constants.API_URL;

public class ApiUtils {
    public static ApiService getApiService() {
        return RetrofitClient.getClient(API_URL).create(ApiService.class);
    }
}
