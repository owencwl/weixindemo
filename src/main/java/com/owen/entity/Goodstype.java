package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Goodstype {
    private String goodstypeid;
    private String goodstypename;

    @Id
    @Column(name = "goodstypeid", nullable = false, length = 255)
    public String getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(String goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    @Basic
    @Column(name = "goodstypename", nullable = true, length = 255)
    public String getGoodstypename() {
        return goodstypename;
    }

    public void setGoodstypename(String goodstypename) {
        this.goodstypename = goodstypename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goodstype goodstype = (Goodstype) o;

        if (goodstypeid != null ? !goodstypeid.equals(goodstype.goodstypeid) : goodstype.goodstypeid != null)
            return false;
        if (goodstypename != null ? !goodstypename.equals(goodstype.goodstypename) : goodstype.goodstypename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodstypeid != null ? goodstypeid.hashCode() : 0;
        result = 31 * result + (goodstypename != null ? goodstypename.hashCode() : 0);
        return result;
    }
}
