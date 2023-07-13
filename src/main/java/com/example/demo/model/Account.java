package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String useName;
    private String pass;
    private String img;
    private Date birthday;
    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(String useName, String pass, String img, Date birthday, Role role) {
        this.useName = useName;
        this.pass = pass;
        this.img = img;
        this.birthday = birthday;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUse() {
        return useName;
    }

    public void setUse(String useName) {
        this.useName = useName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
