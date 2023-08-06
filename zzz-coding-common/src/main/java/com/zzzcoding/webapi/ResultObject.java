package com.zzzcoding.webapi;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 3:57 pm
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultObject<T> {
    /**
     * error code
     */
    private long code;
    /**
     * response message
     */
    private String message;
    /**
     * result
     */
    private T result;
    protected ResultObject() {}

    protected ResultObject(long code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> ResultObject<T> success(T data) {
        return new ResultObject<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 可自定义返回message
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultObject<T> success(T data, String message) {
        return new ResultObject<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultObject<T> failed(IErrorCode errorCode) {
        return new ResultObject<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> ResultObject<T> failed(String message) {
        return new ResultObject<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> ResultObject<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> ResultObject<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static <T> ResultObject<T> validateFailed(String message) {
        return new ResultObject<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    public static <T> ResultObject<T> unauthorized(T data) {
        return new ResultObject<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> ResultObject<T> forbidden(T data) {
        return new ResultObject<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() { return code; }

    public void setCode(long code) { this.code = code; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public T getResult() { return result; }

    public void setResult(T result) { this.result = result; }

}

