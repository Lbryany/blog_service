package org.bryanzzz.dto;

import org.bryanzzz.enums.UserStateEnums;

public class UserExecution {

    private long userId;

    private UserStateEnums userStateEnums;

    public long getUserId() {
        return userId;
    }

    public UserStateEnums getUserStateEnums() {
        return userStateEnums;
    }

    @Override
    public String toString() {
        return "UserExecution{" +
                "userId=" + userId +
                ", userStateEnums=" + userStateEnums +
                '}';
    }

    public UserExecution(long userId, UserStateEnums userStateEnums) {
        this.userId = userId;
        this.userStateEnums = userStateEnums;
    }

    public UserExecution(UserStateEnums userStateEnums) {
        this.userStateEnums = userStateEnums;
    }
}
