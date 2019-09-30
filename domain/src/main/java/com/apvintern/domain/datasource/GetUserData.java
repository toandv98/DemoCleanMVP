package com.apvintern.domain.datasource;

import com.apvintern.domain.entities.User;
import com.apvintern.domain.entities.UserDetail;

import java.util.List;

public interface GetUserData {

    interface GetUserCallBack {

        void onSuccess(List<User> users);

        void onFailure(String msg);
    }

    interface GetUserDetailCallBack {

        void onSuccess(UserDetail userDetail);

        void onFailure(String msg);
    }

    void getUsers(GetUserCallBack getUserCallBack);

    void getUserDetail(int id, GetUserDetailCallBack getUserDetailCallBack);
}
