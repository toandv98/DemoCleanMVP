package com.apvintern.domain.utils;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.domain.entities.UserDetail;

import java.util.ArrayList;
import java.util.List;

public final class UserResponseMapper {
    public UserResponseMapper() {
    }

    public UserResponse toUserResponse(UserDetail userDetail) {
        UserResponse userResponse = null;
        if (userDetail != null) {
            userResponse = new UserResponse(userDetail.getLatitude(),
                    userDetail.getName(),
                    userDetail.getCompany(),
                    userDetail.getEmail(),
                    userDetail.getLongitude());
        }
        return userResponse;
    }

    public List<UserResponse> toUserResponses(List<UserDetail> userDetails) {
        List<UserResponse> userResponses = null;
        if (userDetails != null && !userDetails.isEmpty()) {
            userResponses = new ArrayList<>(userDetails.size());
            for (UserDetail userDetail : userDetails) {
                userResponses.add(toUserResponse(userDetail));
            }
        }
        return userResponses;
    }
}
