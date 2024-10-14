package com.zzzcoding.webapi;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 8:40 pm
 */
public enum ResultCode implements IErrorCode {
    /**
     * success
     */
    SUCCESS(0, "success"),
    /**
     * fail
     */
    FAILED(500, "Failed"),
    VALIDATE_FAILED(506, "Validate failed"),
    UNAUTHORIZED(401, "Token is invalid, please try again."),
    FORBIDDEN(403, "Forbidden"),
    PASSWORD_INCORRECT(10014,"Password is incorrect."),
    ACCOUNT_DISABLED(10015,"This account is disabled."),
    USER_NOT_FOUND(10016,"User not found."),
    INVALID_EMAIL_FORMAT(10017, "Invalid email format");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() { return code; }

    @Override
    public String getMessage() { return message; }
}
