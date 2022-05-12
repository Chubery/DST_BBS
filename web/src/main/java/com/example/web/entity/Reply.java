package com.example.web.entity;

import java.text.SimpleDateFormat;

public class Reply {
    private int r_id;
    private int uid;
    private int s_id;
    private String content;
    private SimpleDateFormat reply_time;

    public Reply() {
    }

    public Reply(int r_id, int uid, int s_id, String content, SimpleDateFormat reply_time) {
        this.r_id = r_id;
        this.uid = uid;
        this.s_id = s_id;
        this.content = content;
        this.reply_time = reply_time;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SimpleDateFormat getReply_time() {
        return reply_time;
    }

    public void setReply_time(SimpleDateFormat reply_time) {
        this.reply_time = reply_time;
    }
}
