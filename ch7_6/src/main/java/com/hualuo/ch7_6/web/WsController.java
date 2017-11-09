package com.hualuo.ch7_6.web;

import com.hualuo.ch7_6.domain.WiselyMessage;
import com.hualuo.ch7_6.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 演示控制器
 *
 * @author Joseph
 * @create 2017/11/9 22:51
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }
}
