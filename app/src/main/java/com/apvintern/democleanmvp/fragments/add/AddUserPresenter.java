package com.apvintern.democleanmvp.fragments.add;

import android.util.Patterns;

import com.apvintern.domain.datasource.UpdateUserData;
import com.apvintern.domain.datasource.UpdateUserImp;
import com.apvintern.domain.entities.UserDetail;

import static com.apvintern.democleanmvp.utils.Constants.COMPANY_ERROR;
import static com.apvintern.democleanmvp.utils.Constants.EMAIL_ERROR;
import static com.apvintern.democleanmvp.utils.Constants.LOCATION_ERROR;
import static com.apvintern.democleanmvp.utils.Constants.NAME_ERROR;

public class AddUserPresenter implements AddUserContract.Presenter {
    private AddUserContract.View addUserView;
    private UpdateUserData updateUserData;

    public AddUserPresenter(AddUserContract.View addUserView) {
        this.addUserView = addUserView;
        updateUserData = new UpdateUserImp();
    }

    @Override
    public void onSaveButtonClick(String name, String company, String email, String latitude, String longitude) {
        if (validate(name, company, email, latitude, longitude)) {
            UserDetail userDetail = new UserDetail(latitude, name, company, email, longitude);
            updateUserData.addUser(userDetail, new UpdateUserData.UpdateUserCallBack() {
                @Override
                public void onSuccess(String msg) {

                }

                @Override
                public void onFailure(String msg) {

                }
            });
        }
    }

    public boolean validate(String name, String company, String email, String latitude, String longitude) {
        boolean result = false;

        if (email.trim().length() == 0) {
            addUserView.showError(EMAIL_ERROR, "Email required!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            addUserView.showError(EMAIL_ERROR, "Invalid email address!");
        } else if (name.trim().length() == 0) {
            addUserView.showError(NAME_ERROR, "Name required!");
        } else if (company.trim().length() == 0) {
            addUserView.showError(COMPANY_ERROR, "Company required!");
        } else if (latitude == null && longitude == null) {
            addUserView.showError(LOCATION_ERROR, "Location required!");
        } else result = true;

        return result;
    }
}
