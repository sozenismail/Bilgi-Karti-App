package com.ismailsozen.bilgilerenteresan;

public class Bilgi {


    int bilgi_id;
    String bilgi_yazi;


    public Bilgi() {
    }

    public Bilgi(String bilgi_yazi) {
        this.bilgi_id = bilgi_id;
        this.bilgi_yazi = bilgi_yazi;
    }

    public int getBilgi_id() {
        return bilgi_id;
    }

    public void setBilgi_id(int bilgi_id) {
        this.bilgi_id = bilgi_id;
    }

    public String getBilgi_yazi() {
        return bilgi_yazi;
    }

    public void setBilgi_yazi(String bilgi_yazi) {
        this.bilgi_yazi = bilgi_yazi;
    }



}
