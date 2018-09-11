package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Create by fraser on 2018/8/31 4:00 PM
 */
@Data
@Entity
public class UserRoleRel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long roleId;


}
