package com.example.shiro.entity.view;

import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import lombok.Data;

/**
 * Create by fraser on 2018/9/10 9:32 PM
 */
@Data
public class UserRoleView {

    private User user;

    private Role role;
}
