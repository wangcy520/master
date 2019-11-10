package com.wm.gameplat.config.exception;

import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常控制处理器
 * @author Wang926454
 * @date 2018/8/30 14:02
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result globalException(Exception e) {
        e.printStackTrace();
        return ResultUtil.error();
    }
}
