package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class RolePermRel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long permId;

    private Long roleId;


}
