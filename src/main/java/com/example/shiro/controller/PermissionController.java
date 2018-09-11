package com.example.shiro.controller;

import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import com.example.shiro.repository.PermissionRepository;
import com.example.shiro.repository.RoleRepository;
import com.example.shiro.vo.PermissionVo;
import com.example.shiro.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by fraser on 2018/9/10 4:12 PM
 */

@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionRepository permissionRepository;

    @Resource
    private MapperFacade mapperFacade;

    @PostMapping
    public void create(@RequestBody PermissionVo permissionVo){
        Permission permission = mapperFacade.map(permissionVo, Permission.class);
        permissionRepository.save(permission);
    }
}
