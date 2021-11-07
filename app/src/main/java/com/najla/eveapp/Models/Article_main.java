package com.najla.eveapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article_main {

    private boolean success;
    @SerializedName("data")
    private List<Article_info> article_infos;

    private String message;






    public boolean isSuccess() {
        return success;
    }

    public List<Article_info> getArticle_infos() {
        return article_infos;
    }

    public String getMessage() {
        return message;
    }
}
