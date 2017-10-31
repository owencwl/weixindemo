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
public class Goods {
    private String goodsid;
    private String goodsname;
    private String goodsdescript;
    private Double goodsprice;
    private String goodsimagename;
    private Integer goodscount;
    private Timestamp goodsdate;
    private String goodstype;

    @Id
    @Column(name = "goodsid", nullable = false, length = 255)
    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "goodsname", nullable = true, length = 255)
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "goodsdescript", nullable = true, length = 255)
    public String getGoodsdescript() {
        return goodsdescript;
    }

    public void setGoodsdescript(String goodsdescript) {
        this.goodsdescript = goodsdescript;
    }

    @Basic
    @Column(name = "goodsprice", nullable = true, precision = 2)
    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    @Basic
    @Column(name = "goodsimagename", nullable = true, length = 255)
    public String getGoodsimagename() {
        return goodsimagename;
    }

    public void setGoodsimagename(String goodsimagename) {
        this.goodsimagename = goodsimagename;
    }

    @Basic
    @Column(name = "goodscount", nullable = true)
    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    @Basic
    @Column(name = "goodsdate", nullable = true)
    public Timestamp getGoodsdate() {
        return goodsdate;
    }

    public void setGoodsdate(Timestamp goodsdate) {
        this.goodsdate = goodsdate;
    }

    @Basic
    @Column(name = "goodstype", nullable = true, length = 255)
    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (goodsid != null ? !goodsid.equals(goods.goodsid) : goods.goodsid != null) return false;
        if (goodsname != null ? !goodsname.equals(goods.goodsname) : goods.goodsname != null) return false;
        if (goodsdescript != null ? !goodsdescript.equals(goods.goodsdescript) : goods.goodsdescript != null)
            return false;
        if (goodsprice != null ? !goodsprice.equals(goods.goodsprice) : goods.goodsprice != null) return false;
        if (goodsimagename != null ? !goodsimagename.equals(goods.goodsimagename) : goods.goodsimagename != null)
            return false;
        if (goodscount != null ? !goodscount.equals(goods.goodscount) : goods.goodscount != null) return false;
        if (goodsdate != null ? !goodsdate.equals(goods.goodsdate) : goods.goodsdate != null) return false;
        if (goodstype != null ? !goodstype.equals(goods.goodstype) : goods.goodstype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsid != null ? goodsid.hashCode() : 0;
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsdescript != null ? goodsdescript.hashCode() : 0);
        result = 31 * result + (goodsprice != null ? goodsprice.hashCode() : 0);
        result = 31 * result + (goodsimagename != null ? goodsimagename.hashCode() : 0);
        result = 31 * result + (goodscount != null ? goodscount.hashCode() : 0);
        result = 31 * result + (goodsdate != null ? goodsdate.hashCode() : 0);
        result = 31 * result + (goodstype != null ? goodstype.hashCode() : 0);
        return result;
    }
}
