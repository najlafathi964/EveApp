package com.najla.eveapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Instiutions_main {

    private boolean success;
    @SerializedName("data")
    private List<Instiutions_info> Instiutions_infos;
    private String message;





    public boolean isSuccess() {
        return success;
    }

    public List<Instiutions_info> getInstiutions_infos() {
        return Instiutions_infos;
    }

    public String getMessage() {
        return message;
    }
}
