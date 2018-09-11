package com.example.shiro.config;

import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.entity.view.RolePermView;
import com.example.shiro.entity.view.UserRoleView;
import com.example.shiro.repository.PermissionRepository;
import com.example.shiro.repository.RoleRepository;
import com.example.shiro.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create by fraser on 2018/8/30 11:29 AM
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) super.getAvailablePrincipal(principals);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<Long> roleIds = roleRepository.findUserRole(user.getId());

        List<Role> roles = roleRepository.findByIdIn(roleIds);

        authorizationInfo.setRoles(roles.stream().map(Role::getRoleCode).distinct().collect(Collectors.toSet()));

        List<Long> permIds = permissionRepository.findRolePerm(roleIds);
        List<Permission> permissions = permissionRepository.findByIdIn(permIds);

        authorizationInfo.addStringPermissions(permissions.stream().map(Permission::getPermCode).distinct().collect(Collectors.toSet()));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userRepository.findUserByUsername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        return simpleAuthenticationInfo;
    }
}
