package com.hualuo.master.error;

/**
 * 自定义异常
 *
 * @author Joseph
 * @create 2017/12/5 14:38
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
