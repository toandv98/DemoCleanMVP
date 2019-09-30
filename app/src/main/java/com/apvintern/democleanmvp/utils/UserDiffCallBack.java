package com.apvintern.democleanmvp.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.apvintern.domain.entities.User;

import java.util.List;

public class UserDiffCallBack extends DiffUtil.Callback {

    private List<User> oldUsers, newUsers;

    public UserDiffCallBack(List<User> oldUsers, List<User> newUsers) {
        this.oldUsers = oldUsers;
        this.newUsers = newUsers;
    }

    @Override
    public int getOldListSize() {
        return oldUsers.size();
    }

    @Override
    public int getNewListSize() {
        return newUsers.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUsers.get(oldItemPosition).getId() == newUsers.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser = oldUsers.get(oldItemPosition);
        User newUser = newUsers.get(newItemPosition);
        return oldUser.getName().equals(newUser.getName())
                && oldUser.getEmail().equals(newUser.getEmail());
    }
}
