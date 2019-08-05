package com.example.shiro.controller;

import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.repository.RoleRepository;
import com.example.shiro.repository.UserRepository;
import com.example.shiro.vo.RoleVo;
import com.example.shiro.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private MapperFacade mapperFacade;

    @PostMapping
    public void create(@RequestBody RoleVo roleVo){
        Role role = mapperFacade.map(roleVo, Role.class);
        roleRepository.save(role);
    }
}
