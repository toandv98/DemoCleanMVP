package com.apvintern.domain.model;

import java.util.List;

public interface UserCallBack {

    void onSuccess(List<UserModel> users);

    void onFailure(String msg);
}
