package com.zzzcoding.exception;

import com.zzzcoding.webapi.ResultCode;
import com.zzzcoding.webapi.ResultObject;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Wenjie Zhang
 * @date 1/12/2022 12:23 am
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResultObject handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return ResultObject.failed(e.getErrorCode());
        }
        return ResultObject.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultObject handleValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        System.out.println(objectError.getDefaultMessage());
        return ResultObject.failed(ResultCode.VALIDATE_FAILED.getCode(), objectError.getDefaultMessage());
    }
}
