package com.apvintern.domain.datasource;

import com.apvintern.domain.entities.UserDetail;

public interface UpdateUserData {
    interface UpdateUserCallBack {
        void onSuccess(String msg);

        void onFailure(String msg);
    }

    void addUser(UserDetail userDetail, UpdateUserCallBack updateUserCallBack);

    void deleteUser(int id, UpdateUserCallBack updateUserCallBack);
}
