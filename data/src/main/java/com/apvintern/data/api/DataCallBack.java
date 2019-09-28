package com.apvintern.data.api;

import com.apvintern.data.entities.User;

import java.util.List;

public interface DataCallBack {
    void onSuccess(List<User> users);

    void onFailure(String msg);
}
