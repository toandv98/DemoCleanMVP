package com.apvintern.domain.utils;

import com.apvintern.data.entities.UserResponse;
import com.apvintern.domain.entities.UserDetail;

import java.util.ArrayList;
import java.util.List;

public class UserDetailMapper {
    public UserDetailMapper() {
    }

    public UserDetail toUserDetail(UserResponse userResponse) {
        UserDetail userDetail = null;
        if (userResponse != null) {
            userDetail = new UserDetail(userDetail.getLatitude(),
                    userDetail.getName(),
                    userDetail.getCompany(),
                    userDetail.getId(),
                    userDetail.getEmail(),
                    userDetail.getLongitude());
        }
        return userDetail;
    }

    public List<UserDetail> toUserDetails(List<UserResponse> userResponses) {
        List<UserDetail> userDetails = null;
        if (userResponses != null && !userResponses.isEmpty()) {
            userDetails = new ArrayList<>(userResponses.size());
            for (UserResponse userResponse : userResponses) {
                userDetails.add(toUserDetail(userResponse));
            }
        }
        return userDetails;
    }
}
