package com.example.shiro.controller;

import com.example.shiro.service.ShiroSampleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by fraser on 2018/8/30 1:49 PM
 */
@RestController
public class ShiroSampleController {

//    @Autowired
//    private ShiroSampleService shiroSampleService;

    @GetMapping("/login")
    public void login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
    }

    @GetMapping("/logout")
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

//    @GetMapping("/read")
//    public String read() {
//        return this.shiroSampleService.read();
//    }
//
//    @GetMapping("/write")
//    public String write() {
//        return this.shiroSampleService.write();
//    }


}
