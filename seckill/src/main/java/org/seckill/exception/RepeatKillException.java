package org.seckill.exception;

/**
 * 重复秒杀异常
 *
 * @author zhangyuhang
 * @date 2018/7/17
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
