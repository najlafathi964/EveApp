package com.najla.eveapp.Models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.najla.eveapp.R;

public class Instiution_adapter extends RecyclerView.Adapter<Instiution_adapter.MyViewHolder>  {


    private List<Instiutions_info> Instiutions_info =null;
    private AdapterView.OnItemClickListener onItemClickListener;

    String url="http://gazaskygeeks.esy.es/public/uploads/ads/";


    public Instiution_adapter(List<Instiutions_info> instiutions_info) {
        Instiutions_info = instiutions_info;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tv_name.setText(Instiutions_info.get(i).getName());
        holder.tv_des.setText(Instiutions_info.get(i).getDes());
      holder.in.setImageResource(R.drawable.in);



    }

    @Override
    public int getItemCount() {
        return Instiutions_info.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_name , tv_des;
        ImageView in;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.name_);
            tv_des = itemView.findViewById(R.id.des_);
            in = itemView.findViewById(R.id.imag_);


        }

        @Override
        public void onClick(View view) {
        }
    }
}
