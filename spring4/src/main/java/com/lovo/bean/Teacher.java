package com.lovo.bean;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity@Table@Data
public class Teacher {

    @Id@Column
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "t_name")
    private String name;
}
