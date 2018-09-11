package com.example.shiro.controller;

import com.example.shiro.entity.User;
import com.example.shiro.repository.UserRepository;
import com.example.shiro.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Create by fraser on 2018/9/10 4:12 PM
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MapperFacade mapperFacade;

//    @Resource
//    private ShiroSampleService shiroSampleService;

    @PostMapping
    public void register(@RequestBody UserVo userVo){
        String salt = RandomStringUtils.randomAlphanumeric(10);
        Md5Hash md5Hash = new Md5Hash(userVo.getPassword(), salt);
        userVo.setPassword(md5Hash.toHex());
        User user = mapperFacade.map(userVo, User.class);
        user.setSalt(salt);
        userRepository.save(user);
    }

    @GetMapping("/login")
    public void login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
    }

    @GetMapping("/logout")
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

    @RequiresPermissions("user.delete")
    @GetMapping("/test")
    public void testVisit(){
//        shiroSampleService.read();
        System.out.println("111");
    }
}
