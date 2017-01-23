package com.daimamiao.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 * java异常分为编译器异常和运行期异常
 * spring事务只接受运行期异常然后回滚
 * Created by xcc on 1/23/2017.
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
