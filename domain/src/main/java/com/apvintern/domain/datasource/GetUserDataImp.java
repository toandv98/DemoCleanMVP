package com.apvintern.domain.datasource;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.data.repository.UserDataApi;
import com.apvintern.data.repository.UserDataApiImp;
import com.apvintern.domain.utils.UserDetailMapper;
import com.apvintern.domain.utils.UserMapper;

import java.util.List;

public class GetUserDataImp implements GetUserData {

    private UserDataApi apiData;
    private UserMapper userMapper;
    private UserDetailMapper userDetailMapper;

    public GetUserDataImp() {
        apiData = new UserDataApiImp();
        userMapper = new UserMapper();
        userDetailMapper = new UserDetailMapper();
    }

    @Override
    public void getUsers(GetUserCallBack getUserCallBack) {
        apiData.getUsers(new UserDataApi.UsersDataCallBack() {
            @Override
            public void onSuccess(List<UserResponse> userResponses) {
                getUserCallBack.onSuccess(userMapper.toUsers(userResponses));
            }

            @Override
            public void onFailure(String msg) {
                getUserCallBack.onFailure(msg);
            }
        });
    }

    @Override
    public void getUserDetail(int id, GetUserDetailCallBack getUserDetailCallBack) {
        apiData.getUserById(id, new UserDataApi.UserDataCallBack() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                getUserDetailCallBack.onSuccess(userDetailMapper.toUserDetail(userResponse));
            }

            @Override
            public void onFailure(String msg) {
                getUserDetailCallBack.onFailure(msg);
            }
        });
    }
}
