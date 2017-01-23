package com.daimamiao.seckill.exception;

/**
 * 秒杀相关业务异常
 * Created by xcc on 1/23/2017.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
