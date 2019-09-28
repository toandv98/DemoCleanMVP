package com.apvintern.domain;

import com.apvintern.data.api.ApiData;
import com.apvintern.data.api.ApiDataImp;
import com.apvintern.data.api.DataCallBack;
import com.apvintern.data.entities.User;
import com.apvintern.domain.model.UserCallBack;
import com.apvintern.domain.model.UserModel;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UserDataImp implements UserData {

    private ApiData apiData;
    private ModelMapper modelMapper;
    private List<UserModel> userModels;

    public UserDataImp() {
        apiData = new ApiDataImp();
        modelMapper = new ModelMapper();
        userModels = new ArrayList<>();
    }

    @Override
    public void getUsers(UserCallBack userCallBack) {
        apiData.getUsers(new DataCallBack() {
            @Override
            public void onSuccess(List<User> users) {
                for (int i = 0; i < users.size(); i++) {
                    userModels.add(modelMapper.map(users.get(i), UserModel.class));
                }
                userCallBack.onSuccess(userModels);
            }

            @Override
            public void onFailure(String msg) {
                userCallBack.onFailure(msg);
            }
        });
    }
}
