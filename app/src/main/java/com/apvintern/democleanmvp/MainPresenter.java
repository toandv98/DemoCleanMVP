package com.apvintern.democleanmvp;

import com.apvintern.domain.UserData;
import com.apvintern.domain.UserDataImp;
import com.apvintern.domain.model.UserCallBack;
import com.apvintern.domain.model.UserModel;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainView;
    private UserData userData;

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        userData = new UserDataImp();
    }


    @Override
    public void onButtonClick() {
        mainView.showProgressBar();
        userData.getUsers(new UserCallBack() {
            @Override
            public void onSuccess(List<UserModel> users) {
                mainView.showMessage(users.get(1).toString());
                mainView.hideProgressBar();
            }

            @Override
            public void onFailure(String msg) {
                mainView.showMessage(msg);
                mainView.hideProgressBar();
            }
        });
    }
}
