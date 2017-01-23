package com.daimamiao.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by xcc on 1/23/2017.
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
