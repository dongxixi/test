package com.lovo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data@Table(name = "t_role")@Entity
public class Role {

    @Id@Column(name = "r_id")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "r_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "r_user_id")
    private User user;
}
