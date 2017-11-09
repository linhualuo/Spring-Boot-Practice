package com.hualuo.ch7_6.domain;

/**
 * 服务端向浏览器发送的信息
 *
 * @author Joseph
 * @create 2017/11/9 22:45
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
