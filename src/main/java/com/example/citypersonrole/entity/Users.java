package com.example.citypersonrole.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = Users.TABLE_NAME)
public class Users {

    public static final String TABLE_NAME = "USERS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_LAST_NAME")
    private String lastName;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private List<Role> roles;

    @Column(name = "USER_ACTIVE")
    private Boolean active;

    @Column(name = "CREATED_DATE")
    private Date date;
}
