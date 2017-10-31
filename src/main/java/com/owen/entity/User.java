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
public class User {
    private int id;
    private String nickname;
    private String image;
    private String email;
    private String tel;
    private Double balance;
    private Integer bonuspoint;
    private String deliveryaddress;
    private Timestamp regdate;
    private Timestamp loaddate;
    private String openid;
    private Byte sex;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 255)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 255)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 255)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "bonuspoint", nullable = true)
    public Integer getBonuspoint() {
        return bonuspoint;
    }

    public void setBonuspoint(Integer bonuspoint) {
        this.bonuspoint = bonuspoint;
    }

    @Basic
    @Column(name = "deliveryaddress", nullable = true, length = 255)
    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    @Basic
    @Column(name = "regdate", nullable = true)
    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Basic
    @Column(name = "loaddate", nullable = true)
    public Timestamp getLoaddate() {
        return loaddate;
    }

    public void setLoaddate(Timestamp loaddate) {
        this.loaddate = loaddate;
    }

    @Basic
    @Column(name = "openid", nullable = false, length = 255)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (image != null ? !image.equals(user.image) : user.image != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;
        if (balance != null ? !balance.equals(user.balance) : user.balance != null) return false;
        if (bonuspoint != null ? !bonuspoint.equals(user.bonuspoint) : user.bonuspoint != null) return false;
        if (deliveryaddress != null ? !deliveryaddress.equals(user.deliveryaddress) : user.deliveryaddress != null)
            return false;
        if (regdate != null ? !regdate.equals(user.regdate) : user.regdate != null) return false;
        if (loaddate != null ? !loaddate.equals(user.loaddate) : user.loaddate != null) return false;
        if (openid != null ? !openid.equals(user.openid) : user.openid != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (bonuspoint != null ? bonuspoint.hashCode() : 0);
        result = 31 * result + (deliveryaddress != null ? deliveryaddress.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        result = 31 * result + (loaddate != null ? loaddate.hashCode() : 0);
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
