package org.seckill.exception;

/**
 * 秒杀关闭异常
 *
 * @author zhangyuhang
 * @date 2018/7/17
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
