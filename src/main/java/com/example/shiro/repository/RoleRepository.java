package com.example.shiro.repository;


import com.example.shiro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select roleId from UserRoleRel ur where ur.userId = ?1")
    List<Long> findUserRole(Long userId);

    List<Role> findByIdIn(List<Long> ids);

}
