package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Create by fraser on 2018/8/31 4:00 PM
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique =true)
    private String username;

    private String password;

    private String salt;

}
