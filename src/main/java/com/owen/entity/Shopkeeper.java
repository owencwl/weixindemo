package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Shopkeeper {
    private String shopkeeperid;
    private String shopkeepername;
    private String shopkeeperpwd;
    private String shopkeepertel;
    private String shopkeeperemail;
    private String shoptypename;

    @Id
    @Column(name = "shopkeeperid", nullable = false, length = 255)
    public String getShopkeeperid() {
        return shopkeeperid;
    }

    public void setShopkeeperid(String shopkeeperid) {
        this.shopkeeperid = shopkeeperid;
    }

    @Basic
    @Column(name = "shopkeepername", nullable = true, length = 255)
    public String getShopkeepername() {
        return shopkeepername;
    }

    public void setShopkeepername(String shopkeepername) {
        this.shopkeepername = shopkeepername;
    }

    @Basic
    @Column(name = "shopkeeperpwd", nullable = true, length = 255)
    public String getShopkeeperpwd() {
        return shopkeeperpwd;
    }

    public void setShopkeeperpwd(String shopkeeperpwd) {
        this.shopkeeperpwd = shopkeeperpwd;
    }

    @Basic
    @Column(name = "shopkeepertel", nullable = true, length = 255)
    public String getShopkeepertel() {
        return shopkeepertel;
    }

    public void setShopkeepertel(String shopkeepertel) {
        this.shopkeepertel = shopkeepertel;
    }

    @Basic
    @Column(name = "shopkeeperemail", nullable = true, length = 255)
    public String getShopkeeperemail() {
        return shopkeeperemail;
    }

    public void setShopkeeperemail(String shopkeeperemail) {
        this.shopkeeperemail = shopkeeperemail;
    }

    @Basic
    @Column(name = "shoptypename", nullable = true, length = 255)
    public String getShoptypename() {
        return shoptypename;
    }

    public void setShoptypename(String shoptypename) {
        this.shoptypename = shoptypename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shopkeeper that = (Shopkeeper) o;

        if (shopkeeperid != null ? !shopkeeperid.equals(that.shopkeeperid) : that.shopkeeperid != null) return false;
        if (shopkeepername != null ? !shopkeepername.equals(that.shopkeepername) : that.shopkeepername != null)
            return false;
        if (shopkeeperpwd != null ? !shopkeeperpwd.equals(that.shopkeeperpwd) : that.shopkeeperpwd != null)
            return false;
        if (shopkeepertel != null ? !shopkeepertel.equals(that.shopkeepertel) : that.shopkeepertel != null)
            return false;
        if (shopkeeperemail != null ? !shopkeeperemail.equals(that.shopkeeperemail) : that.shopkeeperemail != null)
            return false;
        if (shoptypename != null ? !shoptypename.equals(that.shoptypename) : that.shoptypename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopkeeperid != null ? shopkeeperid.hashCode() : 0;
        result = 31 * result + (shopkeepername != null ? shopkeepername.hashCode() : 0);
        result = 31 * result + (shopkeeperpwd != null ? shopkeeperpwd.hashCode() : 0);
        result = 31 * result + (shopkeepertel != null ? shopkeepertel.hashCode() : 0);
        result = 31 * result + (shopkeeperemail != null ? shopkeeperemail.hashCode() : 0);
        result = 31 * result + (shoptypename != null ? shoptypename.hashCode() : 0);
        return result;
    }
}
