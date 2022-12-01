package com.zzzcoding.webapi;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 8:42 pm
 */
public interface IErrorCode {
    /**
     * Get response code
     * @return
     */
    long getCode();

    /**
     * Get response message
     * @return
     */
    String getMessage();
}
