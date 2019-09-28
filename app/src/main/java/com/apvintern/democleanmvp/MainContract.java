package com.apvintern.democleanmvp;

public interface MainContract {
    interface View {
        void showMessage(String msg);

        void showProgressBar();

        void hideProgressBar();
    }

    interface Presenter {
        void onButtonClick();
    }
}
