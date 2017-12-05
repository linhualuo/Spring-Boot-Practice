package com.hualuo.master.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joseph
 * @create 2017/12/6 0:25
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String authenticate() {
        return "login";
    }
}
