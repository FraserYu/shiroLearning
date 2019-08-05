package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique =true)
    private String permCode;

    private String permName;


}
