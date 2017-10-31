package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Coupon {
    private int couponid;
    private String couponname;
    private Integer userid;
    private Integer couponprice;
    private String coupondecript;
    private Integer couponcount;

    @Id
    @Column(name = "couponid", nullable = false)
    public int getCouponid() {
        return couponid;
    }

    public void setCouponid(int couponid) {
        this.couponid = couponid;
    }

    @Basic
    @Column(name = "couponname", nullable = true, length = 255)
    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname;
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
    @Column(name = "couponprice", nullable = true)
    public Integer getCouponprice() {
        return couponprice;
    }

    public void setCouponprice(Integer couponprice) {
        this.couponprice = couponprice;
    }

    @Basic
    @Column(name = "coupondecript", nullable = true, length = 255)
    public String getCoupondecript() {
        return coupondecript;
    }

    public void setCoupondecript(String coupondecript) {
        this.coupondecript = coupondecript;
    }

    @Basic
    @Column(name = "couponcount", nullable = true)
    public Integer getCouponcount() {
        return couponcount;
    }

    public void setCouponcount(Integer couponcount) {
        this.couponcount = couponcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (couponid != coupon.couponid) return false;
        if (couponname != null ? !couponname.equals(coupon.couponname) : coupon.couponname != null) return false;
        if (userid != null ? !userid.equals(coupon.userid) : coupon.userid != null) return false;
        if (couponprice != null ? !couponprice.equals(coupon.couponprice) : coupon.couponprice != null) return false;
        if (coupondecript != null ? !coupondecript.equals(coupon.coupondecript) : coupon.coupondecript != null)
            return false;
        if (couponcount != null ? !couponcount.equals(coupon.couponcount) : coupon.couponcount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couponid;
        result = 31 * result + (couponname != null ? couponname.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (couponprice != null ? couponprice.hashCode() : 0);
        result = 31 * result + (coupondecript != null ? coupondecript.hashCode() : 0);
        result = 31 * result + (couponcount != null ? couponcount.hashCode() : 0);
        return result;
    }
}
