package com.zzzcoding.state;

/**
 * @author Wenjie Zhang
 * @date 30/9/2022 9:19 am
 */
public enum UserStatus {
    /**
     * Enable status
     */
    ENABLE(0),
    /**
     * Disable status
     */
    DISABLED(1);

    private int status;

    UserStatus(int status) {this.status = status;}

    public int getUserStatus() {return status;}
}
