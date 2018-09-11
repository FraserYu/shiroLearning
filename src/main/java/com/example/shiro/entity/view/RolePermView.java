package com.example.shiro.entity.view;

import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import lombok.Data;

/**
 * Create by fraser on 2018/9/11 9:27 AM
 */
@Data
public class RolePermView {

    private Role role;

    private Permission permission;
}
