package com.easymemo.pojo;

public class UserInfo {
    private String userAccount;

    public UserInfo() {
    }

    public UserInfo(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userAccount='" + userAccount + '\'' +
                '}';
    }
}
