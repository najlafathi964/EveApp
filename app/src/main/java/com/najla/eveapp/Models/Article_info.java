package com.najla.eveapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article_info {

    @SerializedName("id")
    private int id;

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("name")
    private String name;

    @SerializedName("describe")
    private String Des;

    @SerializedName("created_at")
    private String create_at;

    public List<Article_info> getGetArticle() {
        return getArticle;
    }

    private List<Article_info> getArticle = null;


///////////////////////////////////


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return Des;
    }

    public String getCreate_at() {
        return create_at;
    }

    public String getImage() {
        return image;
    }
}
