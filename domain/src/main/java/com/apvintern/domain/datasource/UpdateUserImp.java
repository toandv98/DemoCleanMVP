package com.apvintern.domain.datasource;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.data.repository.UserDataApi;
import com.apvintern.data.repository.UserDataApiImp;
import com.apvintern.domain.entities.UserDetail;
import com.apvintern.domain.utils.UserResponseMapper;

public class UpdateUserImp implements UpdateUserData {

    private UserDataApi apiData;
    private UserResponseMapper userResponseMapper;

    public UpdateUserImp() {
        apiData = new UserDataApiImp();
        userResponseMapper = new UserResponseMapper();
    }

    @Override
    public void addUser(UserDetail userDetail, UpdateUserCallBack updateUserCallBack) {
        UserResponse userResponse = userResponseMapper.toUserResponse(userDetail);
        apiData.addUser(userResponse, new UserDataApi.UserDataCallBack() {
            @Override
            public void onSuccess(UserResponse userResponse) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    @Override
    public void deleteUser(int id, UpdateUserCallBack updateUserCallBack) {
        apiData.deleteUser(id, new UserDataApi.UserDataCallBack() {
            @Override
            public void onSuccess(UserResponse userResponse) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
