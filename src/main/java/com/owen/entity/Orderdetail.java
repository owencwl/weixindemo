package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Orderdetail {
    private Integer oid;
    private String gid;
    private int orderdetailid;

    @Basic
    @Column(name = "oid", nullable = true)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "gid", nullable = true, length = 255)
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Id
    @Column(name = "orderdetailid", nullable = false)
    public int getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(int orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdetail that = (Orderdetail) o;

        if (orderdetailid != that.orderdetailid) return false;
        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;
        if (gid != null ? !gid.equals(that.gid) : that.gid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid != null ? oid.hashCode() : 0;
        result = 31 * result + (gid != null ? gid.hashCode() : 0);
        result = 31 * result + orderdetailid;
        return result;
    }
}
