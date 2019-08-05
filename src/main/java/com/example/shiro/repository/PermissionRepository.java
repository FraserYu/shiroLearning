package com.example.shiro.repository;


import com.example.shiro.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query(value = "select permId from RolePermRel pr where pr.roleId in ?1")
    List<Long> findRolePerm(List<Long> roleIds);

    List<Permission> findByIdIn(List<Long> ids);
}
