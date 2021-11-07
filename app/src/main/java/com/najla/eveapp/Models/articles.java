package com.najla.eveapp.Models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface articles {
    @GET ("articles")
    Call<Article_main> getArticle();

    //@GET("institutions")
   // Call<Article_main> getInstiutions();

}
