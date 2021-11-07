package com.najla.eveapp.Models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Institution {


    @GET("institutions")
    Call<Instiutions_main> getInstiutions();

}
