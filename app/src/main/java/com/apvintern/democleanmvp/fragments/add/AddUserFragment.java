package com.apvintern.democleanmvp.fragments.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.apvintern.democleanmvp.R;

public class AddUserFragment extends Fragment implements AddUserContract.View {

    private AddUserContract.Presenter addUserPresenter;

    public AddUserFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        addUserPresenter = new AddUserPresenter(this);

        return view;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setCompany(String company) {

    }

    @Override
    public void setLocation(String location) {

    }

    @Override
    public void showError(int errorCode, String msg) {

    }
}
