package com.najla.eveapp.Models;

import android.util.Log;

import java.sql.ResultSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class network {
    private static Retrofit retrofit = null;
    private  static final String BASE_URL = "http://gazaskygeeks.esy.es/api/";

   // private final String APP_ID = "IwAR2YW0tBgWvl5D8R8sT4jmwGdBQ1fRjpjqWyrn3qkD4qCcoRna9vFAww43g";

    static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
