package com.example.web.entity;

import java.util.Date;

public class Subject {
    private int s_id;
    private int uid;
    private String username;
    private int l_id;
    private String l_name;
    private String s_title;
    private String s_detail;
    private int reply_count;
    private String create_time;
    private String last_reply_time;
    private String last_reply_username;

    public Subject() {
    }

    public Subject(int s_id, int uid, String username, int l_id, String l_name, String s_title, String s_detail, int reply_count, String create_time, String last_reply_time, String last_reply_username) {
        this.s_id = s_id;
        this.uid = uid;
        this.username = username;
        this.l_id = l_id;
        this.l_name = l_name;
        this.s_title = s_title;
        this.s_detail = s_detail;
        this.reply_count = reply_count;
        this.create_time = create_time;
        this.last_reply_time = last_reply_time;
        this.last_reply_username = last_reply_username;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public String getS_detail() {
        return s_detail;
    }

    public void setS_detail(String s_detail) {
        this.s_detail = s_detail;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_reply_time() {
        return last_reply_time;
    }

    public void setLast_reply_time(String last_reply_time) {
        this.last_reply_time = last_reply_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_reply_username() {
        return last_reply_username;
    }

    public void setLast_reply_username(String last_reply_username) {
        this.last_reply_username = last_reply_username;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
}
