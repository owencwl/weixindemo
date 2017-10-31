package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Order {
    private int orderid;
    private Integer userid;
    private Double totalmomey;
    private Timestamp orderdate;
    private Byte orderstate;

    @Id
    @Column(name = "orderid", nullable = false)
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "totalmomey", nullable = true, precision = 0)
    public Double getTotalmomey() {
        return totalmomey;
    }

    public void setTotalmomey(Double totalmomey) {
        this.totalmomey = totalmomey;
    }

    @Basic
    @Column(name = "orderdate", nullable = true)
    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "orderstate", nullable = true)
    public Byte getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Byte orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderid != order.orderid) return false;
        if (userid != null ? !userid.equals(order.userid) : order.userid != null) return false;
        if (totalmomey != null ? !totalmomey.equals(order.totalmomey) : order.totalmomey != null) return false;
        if (orderdate != null ? !orderdate.equals(order.orderdate) : order.orderdate != null) return false;
        if (orderstate != null ? !orderstate.equals(order.orderstate) : order.orderstate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (totalmomey != null ? totalmomey.hashCode() : 0);
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (orderstate != null ? orderstate.hashCode() : 0);
        return result;
    }
}
