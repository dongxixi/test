package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "t_user")
@Entity
public class UserEntity {
    @Id
    @Column(name = "u_id", length = 32)
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;
    @Column(name = "u_name", length = 48)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
