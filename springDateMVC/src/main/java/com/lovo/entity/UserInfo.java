package com.lovo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class UserInfo {

    @Id
    @Column
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @ManyToOne
    private User user;

    @Column
    private double salary;

    @Column
    private Date year;
}
