package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Shop {
    private String shopid;
    private String shopname;
    private String shoptel;
    private String shopemail;
    private String shopaddress;
    private String shopdescript;
    private String shopimagename;
    private String shopnotice;
    private String shoptypename;
    private String shopboss;

    @Id
    @Column(name = "shopid", nullable = false, length = 255)
    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    @Basic
    @Column(name = "shopname", nullable = true, length = 255)
    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    @Basic
    @Column(name = "shoptel", nullable = true, length = 255)
    public String getShoptel() {
        return shoptel;
    }

    public void setShoptel(String shoptel) {
        this.shoptel = shoptel;
    }

    @Basic
    @Column(name = "shopemail", nullable = true, length = 255)
    public String getShopemail() {
        return shopemail;
    }

    public void setShopemail(String shopemail) {
        this.shopemail = shopemail;
    }

    @Basic
    @Column(name = "shopaddress", nullable = true, length = 255)
    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    @Basic
    @Column(name = "shopdescript", nullable = true, length = 255)
    public String getShopdescript() {
        return shopdescript;
    }

    public void setShopdescript(String shopdescript) {
        this.shopdescript = shopdescript;
    }

    @Basic
    @Column(name = "shopimagename", nullable = true, length = 255)
    public String getShopimagename() {
        return shopimagename;
    }

    public void setShopimagename(String shopimagename) {
        this.shopimagename = shopimagename;
    }

    @Basic
    @Column(name = "shopnotice", nullable = true, length = 255)
    public String getShopnotice() {
        return shopnotice;
    }

    public void setShopnotice(String shopnotice) {
        this.shopnotice = shopnotice;
    }

    @Basic
    @Column(name = "shoptypename", nullable = true, length = 255)
    public String getShoptypename() {
        return shoptypename;
    }

    public void setShoptypename(String shoptypename) {
        this.shoptypename = shoptypename;
    }

    @Basic
    @Column(name = "shopboss", nullable = true, length = 255)
    public String getShopboss() {
        return shopboss;
    }

    public void setShopboss(String shopboss) {
        this.shopboss = shopboss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopid != null ? !shopid.equals(shop.shopid) : shop.shopid != null) return false;
        if (shopname != null ? !shopname.equals(shop.shopname) : shop.shopname != null) return false;
        if (shoptel != null ? !shoptel.equals(shop.shoptel) : shop.shoptel != null) return false;
        if (shopemail != null ? !shopemail.equals(shop.shopemail) : shop.shopemail != null) return false;
        if (shopaddress != null ? !shopaddress.equals(shop.shopaddress) : shop.shopaddress != null) return false;
        if (shopdescript != null ? !shopdescript.equals(shop.shopdescript) : shop.shopdescript != null) return false;
        if (shopimagename != null ? !shopimagename.equals(shop.shopimagename) : shop.shopimagename != null)
            return false;
        if (shopnotice != null ? !shopnotice.equals(shop.shopnotice) : shop.shopnotice != null) return false;
        if (shoptypename != null ? !shoptypename.equals(shop.shoptypename) : shop.shoptypename != null) return false;
        if (shopboss != null ? !shopboss.equals(shop.shopboss) : shop.shopboss != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopid != null ? shopid.hashCode() : 0;
        result = 31 * result + (shopname != null ? shopname.hashCode() : 0);
        result = 31 * result + (shoptel != null ? shoptel.hashCode() : 0);
        result = 31 * result + (shopemail != null ? shopemail.hashCode() : 0);
        result = 31 * result + (shopaddress != null ? shopaddress.hashCode() : 0);
        result = 31 * result + (shopdescript != null ? shopdescript.hashCode() : 0);
        result = 31 * result + (shopimagename != null ? shopimagename.hashCode() : 0);
        result = 31 * result + (shopnotice != null ? shopnotice.hashCode() : 0);
        result = 31 * result + (shoptypename != null ? shoptypename.hashCode() : 0);
        result = 31 * result + (shopboss != null ? shopboss.hashCode() : 0);
        return result;
    }
}
