package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class OrderEntity {

    @Id
    @Column(name = "o_id")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "o_in_time", columnDefinition = "Timestamp")
    private Date inTime;

    @Column(name = "o_out_time", columnDefinition = "Timestamp", nullable = true)
    private Date outTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
