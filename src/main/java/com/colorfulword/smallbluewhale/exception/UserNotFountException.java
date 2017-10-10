package com.colorfulword.smallbluewhale.exception;

/**
 * Created by jone.sun on 2017/6/30.
 */
public class UserNotFountException extends RuntimeException{
    private String userId;

    public UserNotFountException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}