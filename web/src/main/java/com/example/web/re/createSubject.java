package com.example.web.re;

public class createSubject {
    private int l_id;
    private String s_title;
    private String s_detail;

    public createSubject() {
    }

    public createSubject(int l_id, String s_title, String s_detail) {
        this.l_id = l_id;
        this.s_title = s_title;
        this.s_detail = s_detail;
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
}
