package com.apvintern.democleanmvp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.apvintern.democleanmvp.R;
import com.apvintern.democleanmvp.adapters.UserAdapter;
import com.apvintern.democleanmvp.fragments.add.AddUserFragment;
import com.apvintern.domain.entities.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mainPresenter;
    private RecyclerView rvUsers;
    private FloatingActionButton fabAdd;
    private SwipeRefreshLayout srlUsers;
    private ProgressBar pbLoading;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate();
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.onButtonClick();
            }
        });
        srlUsers.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.onRefreshing();
            }
        });
    }

    private void initView() {
        rvUsers = findViewById(R.id.rv_main_users_list);
        srlUsers = findViewById(R.id.srl_main_reload);
        fabAdd = findViewById(R.id.fab_main_add);
        pbLoading = findViewById(R.id.pb_main_loading);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void hideSwipeRefreshLayout() {
        srlUsers.setRefreshing(false);
    }

    @Override
    public void loadRecycleView(List<User> users) {
        userAdapter = new UserAdapter(users, mainPresenter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvUsers.setLayoutManager(layoutManager);
        rvUsers.setAdapter(userAdapter);
    }

    @Override
    public void updateRecycleView(List<User> users) {
        userAdapter.updateUsers(users);
    }

    @Override
    public void navigateToAddFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_main_container, new AddUserFragment())
                .addToBackStack("add_user")
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
