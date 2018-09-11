package com.example.shiro.repository;

//import com.example.shiro.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by fraser on 2018/8/30 11:34 AM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUsername(String username);

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
