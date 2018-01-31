package com.tsw.networkrepair.user.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tsw.networkrepair.base.CustomJsonDateDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserModel {
    int id;
    private String username;
    private String password;
    private String name;
    private int level;

    private Date create_dt;

    private Date last_dt;
    private String ip;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public Date getLast_dt() {
        return last_dt;
    }
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setLast_dt(Date last_dt) {
        this.last_dt = last_dt;
    }

}
