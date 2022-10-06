package com.example.citypersonrole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = Role.TABLE_NAME)
public class Role {

    public static final String TABLE_NAME = "ROLES";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ_NAME)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role")
    private String role;
}
