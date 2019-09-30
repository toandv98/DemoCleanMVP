package com.apvintern.democleanmvp.activities;

import com.apvintern.domain.entities.User;

import java.util.List;

public interface MainContract {

    interface View {
        void showMessage(String msg);

        void showProgressBar();

        void hideProgressBar();

        void hideSwipeRefreshLayout();

        void loadRecycleView(List<User> users);

        void updateRecycleView(List<User> users);

        void navigateToAddFragment();
    }

    interface Presenter {
        void onButtonClick();

        void onRefreshing();

        void onCreateMain();

        void onItemClick(int position);
    }
}
