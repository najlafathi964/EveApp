package com.najla.eveapp.Models;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.najla.eveapp.Models.ArticleAdapter;
import com.najla.eveapp.Models.Article_info;
import com.najla.eveapp.Models.Article_main;
import com.najla.eveapp.Models.articles;
import com.najla.eveapp.Models.network;
import com.najla.eveapp.Models.viewpager_adapter;
import com.najla.eveapp.R;

import java.util.List;


public class ArticleFragment_ extends Fragment {

    RecyclerView recyclerView;
    Toolbar toolbar ;
    ViewPager viewPager;
    ArticleAdapter adapter;
com.najla.eveapp.Models.articles articles;
com.najla.eveapp.Models.network network;


int[]image= new int[]{
R.drawable.advv,
        R.drawable.adv2
};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_fragment_, container,
                false);

        getActivity().setTitle(R.string.app_name);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        viewPager=view.findViewById(R.id.viewpager_adv);
        viewpager_adapter viewpager_adapter =new viewpager_adapter(image);
        viewPager.setAdapter(viewpager_adapter);


         load();
        return view;
    }

    public void load() {

        articles apiInterface = network.getClient().create(articles.class);
        Call<Article_main> call = apiInterface.getArticle();
        call.enqueue(new Callback<Article_main>() {
            @Override
            public void onResponse(Call<Article_main> call, Response<Article_main> response) {
                Log.d("Error", response.body().toString());

                List<Article_info> article_info = response.body().getArticle_infos();
                adapter = new ArticleAdapter(article_info);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Article_main> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }










}
