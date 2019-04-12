package com.lovo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_park")
public class ParkEntity {

    @Id
    @Column(name = "p_id")
    private String id;

    @Column(name = "p_total")
    private int total;

    @Column(name = "p_using")
    private int using;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUsing() {
        return using;
    }

    public void setUsing(int using) {
        this.using = using;
    }
}
