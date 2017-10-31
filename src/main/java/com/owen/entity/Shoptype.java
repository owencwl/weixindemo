package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Shoptype {
    private String shoptypeid;
    private String shoptypename;

    @Basic
    @Column(name = "shoptypeid", nullable = true, length = 255)
    public String getShoptypeid() {
        return shoptypeid;
    }

    public void setShoptypeid(String shoptypeid) {
        this.shoptypeid = shoptypeid;
    }

    @Id
    @Column(name = "shoptypename", nullable = false, length = 255)
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

        Shoptype shoptype = (Shoptype) o;

        if (shoptypeid != null ? !shoptypeid.equals(shoptype.shoptypeid) : shoptype.shoptypeid != null) return false;
        if (shoptypename != null ? !shoptypename.equals(shoptype.shoptypename) : shoptype.shoptypename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoptypeid != null ? shoptypeid.hashCode() : 0;
        result = 31 * result + (shoptypename != null ? shoptypename.hashCode() : 0);
        return result;
    }
}
