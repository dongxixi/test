package com.lovo.bean;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data@Entity@Table(name = "t_stu")
public class Student {

    @Id@Column(name = "t_id")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "t_name")
    private String name;
}
