package com.zzzcoding.exception;

import com.zzzcoding.webapi.IErrorCode;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 10:51 pm
 */
public class Asserts {
    public static void fail(String message) { throw new ApiException(message); }

    public static void fail(IErrorCode errorCode) { throw new ApiException(errorCode); }
}

