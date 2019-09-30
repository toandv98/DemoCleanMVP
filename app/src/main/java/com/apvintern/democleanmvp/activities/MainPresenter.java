package com.apvintern.democleanmvp.activities;

import com.apvintern.domain.datasource.GetUserData;
import com.apvintern.domain.datasource.GetUserDataImp;
import com.apvintern.domain.entities.User;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainView;
    private GetUserData getUserData;

    private GetUserData.GetUserCallBack getUserCallBack = new GetUserData.GetUserCallBack() {
        @Override
        public void onSuccess(List<User> users) {
            mainView.updateRecycleView(users);
            mainView.hideSwipeRefreshLayout();
        }

        @Override
        public void onFailure(String msg) {
            mainView.showMessage(msg);
        }
    };

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        getUserData = new GetUserDataImp();
    }

    @Override
    public void onButtonClick() {
        mainView.navigateToAddFragment();
    }

    @Override
    public void onRefreshing() {
        getUserData.getUsers(getUserCallBack);
    }

    @Override
    public void onCreate() {
        mainView.showProgressBar();
        getUserData.getUsers(new GetUserData.GetUserCallBack() {
            @Override
            public void onSuccess(List<User> users) {
                mainView.loadRecycleView(users);
                mainView.hideProgressBar();
            }

            @Override
            public void onFailure(String msg) {
                mainView.showMessage(msg);
                mainView.hideProgressBar();
            }
        });
    }

    @Override
    public void onDestroy() {
        getUserCallBack = null;
    }

    @Override
    public void onItemClick(int position) {
        mainView.showMessage(String.valueOf(position));
    }
}
