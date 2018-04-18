package org.bryanzzz.dto;

import org.bryanzzz.enums.UserStateEnums;

public class UserExecution {

    private String token;

    private UserStateEnums userStateEnums;

    public String getToken() {
        return token;
    }

    public UserStateEnums getUserStateEnums() {
        return userStateEnums;
    }

    @Override
    public String toString() {
        return "UserExecution{" +
                "token='" + token + '\'' +
                ", userStateEnums=" + userStateEnums +
                '}';
    }

    public UserExecution(String token, UserStateEnums userStateEnums) {
        this.token = token;
        this.userStateEnums = userStateEnums;
    }


    public UserExecution(UserStateEnums userStateEnums) {
        this.userStateEnums = userStateEnums;
    }
}
