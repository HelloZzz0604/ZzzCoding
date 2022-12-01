package com.zzzcoding.exception;

import com.zzzcoding.webapi.IErrorCode;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 10:53 pm
 */
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) { super(message); }

    public ApiException(Throwable cause) { super(cause); }

    public ApiException(String message, Throwable cause) { super(message, cause); }

    public IErrorCode getErrorCode() { return errorCode; }
}

