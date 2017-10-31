package com.owen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by owen on 2017/4/11.
 */
@Entity
public class Admin {
    private String adminname;
    private String adminpwd;

    @Id
    @Column(name = "adminname", nullable = false, length = 255)
    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @Basic
    @Column(name = "adminpwd", nullable = true, length = 255)
    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (adminname != null ? !adminname.equals(admin.adminname) : admin.adminname != null) return false;
        if (adminpwd != null ? !adminpwd.equals(admin.adminpwd) : admin.adminpwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminname != null ? adminname.hashCode() : 0;
        result = 31 * result + (adminpwd != null ? adminpwd.hashCode() : 0);
        return result;
    }
}
