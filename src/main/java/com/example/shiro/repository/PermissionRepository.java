package com.example.shiro.repository;


import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.view.RolePermView;
import com.example.shiro.entity.view.UserRoleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by fraser on 2018/8/30 11:34 AM
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query(value = "select permId from RolePermRel pr where pr.roleId in ?1")
    List<Long> findRolePerm(List<Long> roleIds);

    List<Permission> findByIdIn(List<Long> ids);

//    public User findUserByUsername(String username);

//    public Set<String> getRolesByUsername(String username) {
//        Set<String> roles = new HashSet<>();
//        switch (username) {
//            case "zhangsan":
//                roles.add("admin");
//                break;
//            case "lisi":
//                roles.add("guest");
//                break;
//        }
//        return roles;
//    }
//
//    public Set<String> getPermissionsByRole(String role) {
//        Set<String> permissions = new HashSet<>();
//        switch (role) {
//            case "admin":
//                permissions.add("read");
//                permissions.add("write");
//                break;
//            case "guest":
//                permissions.add("read");
//                break;
//        }
//        return permissions;
//    }
//
//    public String getPasswordByUsername(String username) {
//        switch (username) {
//            case "zhangsan":
//                return "zhangsan";
//            case "lisi":
//                return "lisi";
//        }
//        return null;
//    }
}
