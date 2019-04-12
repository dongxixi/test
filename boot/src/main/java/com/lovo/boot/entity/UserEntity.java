package com.lovo.boot.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @Column(name = "u_id", length = 32)
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "u_name", length = 48)
    private String name;

    @Column(name = "u_password", length = 48)
    private String password;


}
