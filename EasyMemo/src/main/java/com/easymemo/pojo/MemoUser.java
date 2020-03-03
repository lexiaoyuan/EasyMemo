package com.easymemo.pojo;

import java.util.Date;

public class MemoUser {
    private int memoId;
    private String userAccount;
    private String memoContent;
    private String memoAccount;
    private String memoPassword;
    private String memoNote;
    private Date memoDate;

    public MemoUser() {
    }

    public MemoUser(int memoId, String userAccount, String memoContent, String memoAccount, String memoPassword, String memoNote, Date memoDate) {
        this.memoId = memoId;
        this.userAccount = userAccount;
        this.memoContent = memoContent;
        this.memoAccount = memoAccount;
        this.memoPassword = memoPassword;
        this.memoNote = memoNote;
        this.memoDate = memoDate;
    }

    public int getMemoId() {
        return memoId;
    }

    public void setMemoId(int memoId) {
        this.memoId = memoId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }

    public String getMemoAccount() {
        return memoAccount;
    }

    public void setMemoAccount(String memoAccount) {
        this.memoAccount = memoAccount;
    }

    public String getMemoPassword() {
        return memoPassword;
    }

    public void setMemoPassword(String memoPassword) {
        this.memoPassword = memoPassword;
    }

    public String getMemoNote() {
        return memoNote;
    }

    public void setMemoNote(String memoNote) {
        this.memoNote = memoNote;
    }

    public Date getMemoDate() {
        return memoDate;
    }

    public void setMemoDate(Date memoDate) {
        this.memoDate = memoDate;
    }

    @Override
    public String toString() {
        return "MemoUser{" +
                "memoId=" + memoId +
                ", userAccount='" + userAccount + '\'' +
                ", memoContent='" + memoContent + '\'' +
                ", memoAccount='" + memoAccount + '\'' +
                ", memoPassword='" + memoPassword + '\'' +
                ", memoNote='" + memoNote + '\'' +
                ", memoDate=" + memoDate +
                '}';
    }
}
