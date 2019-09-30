package com.apvintern.domain.utils;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

public final class UserMapper {
    public UserMapper() {
    }

    public User toUser(UserResponse userResponse) {
        User user = null;
        if (userResponse != null) {
            user = new User(userResponse.getName(),
                    userResponse.getId(),
                    userResponse.getEmail());
        }
        return user;
    }

    public List<User> toUsers(List<UserResponse> userResponses) {
        List<User> users = null;
        if (userResponses != null && !userResponses.isEmpty()) {
            users = new ArrayList<>(userResponses.size());
            for (UserResponse userResponse : userResponses) {
                users.add(toUser(userResponse));
            }
        }
        return users;
    }
}
