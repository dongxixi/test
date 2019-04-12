package com.lovo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class User {

    @Id@Column
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy = "role")
    private Set<Role> roles;
}
