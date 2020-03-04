package com.easymemo.pojo;

public class User {
    private String userAccount;

    public User() {
    }

    public User(String userAccount) {
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
        return "User{" +
                "userAccount='" + userAccount + '\'' +
                '}';
    }
}
