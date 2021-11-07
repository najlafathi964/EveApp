package com.najla.eveapp.Models;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.najla.eveapp.Models.Institution;
import com.najla.eveapp.Models.Instiution_adapter;
import com.najla.eveapp.Models.Instiutions_info;
import com.najla.eveapp.Models.Instiutions_main;
import com.najla.eveapp.Models.network;
import com.najla.eveapp.R;

import java.util.List;

public class InstitutionsFragment extends Fragment {

    Toolbar toolbar;
    private RecyclerView mRecyclerView ;

    Instiution_adapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_institutions, container, false);
        mRecyclerView = view.findViewById(R.id.mRecyclerView_in);
       // mRecyclerView.setHasFixedSize(true);
        int numberOfColumns = 2;
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
       // mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);


        load();
        return view;
    }


    public void load(){


        Institution apiInterface =  network.getClient().create(Institution.class);

        Call<Instiutions_main> call = apiInterface.getInstiutions();
        call.enqueue(new Callback<Instiutions_main>() {
            @Override
            public void onResponse(Call<Instiutions_main> call, Response<Instiutions_main> response) {



                List<Instiutions_info> Instiutions_info = response.body().getInstiutions_infos();
                adapter = new Instiution_adapter(Instiutions_info);
                mRecyclerView.setAdapter(adapter);
                Log.d("Error",Instiutions_info.toString());
            }

            @Override
            public void onFailure(Call<Instiutions_main> call, Throwable t) {
                Log.d("Error", t.getMessage());


            }

        });



    }




}

