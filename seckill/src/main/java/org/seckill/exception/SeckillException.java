package org.seckill.exception;

/**
 * 秒杀异常
 *
 * @author zhangyuhang
 * @date 2018/7/17
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
