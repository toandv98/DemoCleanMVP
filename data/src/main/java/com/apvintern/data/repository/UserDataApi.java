package com.apvintern.data.repository;

import com.apvintern.data.entities.UserResponse;

import java.util.List;

public interface UserDataApi {

    interface UsersDataCallBack {
        void onSuccess(List<UserResponse> userResponses);

        void onFailure(String msg);
    }

    interface UserDataCallBack {
        void onSuccess(UserResponse userResponse);

        void onFailure(String msg);
    }

    void getUsers(UsersDataCallBack usersDataCallBack);

    void getUserById(int id, UserDataCallBack userDataCallBack);

    void addUser(UserResponse userResponse, UserDataCallBack userDataCallBack);

    void deleteUser(int id, UserDataCallBack userDataCallBack);
}
