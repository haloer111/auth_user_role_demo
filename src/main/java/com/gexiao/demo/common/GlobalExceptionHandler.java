package com.gexiao.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 业务异常处理
     *
     * @param e
     * @return Result
     */
    @ExceptionHandler(RuntimeException.class)
    public Result serviceExceptionHandler(RuntimeException e) {
        log.info("业务异常捕获", e);
        return Result.fail(e.getMessage());
    }


    /**
     * 默认处理
     *
     * @param e
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result defaultExceptionHandler(Exception e) {
        if (e instanceof RuntimeException) {
            log.warn("运行异常捕获", e);
        } else {
            log.error("全局异常捕获", e);
        }
        return Result.fail(e);
    }

}
