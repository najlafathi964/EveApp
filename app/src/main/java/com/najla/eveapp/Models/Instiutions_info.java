package com.najla.eveapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Instiutions_info {

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("des")
    String des ;
    @SerializedName("image")
    String image;
    @SerializedName("url_web")
    String url_web;
    @SerializedName("url_fb")
    String url_fb;
    @SerializedName("email")
    String email;
    @SerializedName("phon")
    String phon;
    @SerializedName("Location")
    String Location;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("updated_at")
    String updated_at;



    @SerializedName("deleted_at")
    String deleted_at;

    public List<Instiutions_info> getInstiutions_info() {
        return Instiutions_info;
    }

    private List<Instiutions_info> Instiutions_info = null;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getImage() {
        return image;
    }

    public String getUrl_web() {
        return url_web;
    }

    public String getUrl_fb() {
        return url_fb;
    }

    public String getEmail() {
        return email;
    }

    public String getPhon() {
        return phon;
    }

    public String getLocation() {
        return Location;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }



}
