package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class UserRoleRel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long roleId;


}
