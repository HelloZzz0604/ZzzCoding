package com.zzzcoding.state;

/**
 * @author Wenjie Zhang
 * @date 30/9/2022 9:19 am
 */
public enum UserStatus {
    /**
     * Enable status
     */
    ENABLE(1),
    /**
     * Disable status
     */
    DISABLED(0);

    private int status;

    UserStatus(int status) {this.status = status;}

    public int getUserStatus() {return status;}
}
