package org.bryanzzz.dto;

import org.bryanzzz.enums.UserStateEnums;

public class UserExecution {

    private long uid;

    private UserStateEnums userStateEnums;

    public long getUid() {
        return uid;
    }

    public UserStateEnums getUserStateEnums() {
        return userStateEnums;
    }

    @Override
    public String toString() {
        return "UserExecution{" +
                "uid=" + uid +
                ", userStateEnums=" + userStateEnums +
                '}';
    }

    public UserExecution(long uid, UserStateEnums userStateEnums) {
        this.uid = uid;
        this.userStateEnums = userStateEnums;
    }

    public UserExecution(UserStateEnums userStateEnums) {
        this.userStateEnums = userStateEnums;
    }
}
