package com.example.shiro.repository;

//import com.example.shiro.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUsername(String username);

}
