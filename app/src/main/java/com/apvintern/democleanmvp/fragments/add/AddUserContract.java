package com.apvintern.democleanmvp.fragments.add;

public interface AddUserContract {
    interface View {
        void setEmail(String email);

        void setName(String name);

        void setCompany(String company);

        void setLocation(String location);

        void showError(int errorCode, String msg);
    }

    interface Presenter {
        void onSaveButtonClick(String name, String company,
                               String email, String latitude,
                               String longitude);
    }
}
