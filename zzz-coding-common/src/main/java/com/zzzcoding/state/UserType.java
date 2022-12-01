package com.zzzcoding.state;

/**
 * @author Wenjie Zhang
 * @date 30/9/2022 12:10 am
 */
public enum UserType {
    /**
     * Backoffice
     */
    BACKEND(0),
    /**
     * Front
     */
    FRONT(1);
    private int userType;

    UserType(int userType) { this.userType = userType; }

    public int getUserType() { return userType;}
}
