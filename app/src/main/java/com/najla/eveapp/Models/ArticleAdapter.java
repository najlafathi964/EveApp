package com.najla.eveapp.Models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.najla.eveapp.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article_info> Article_info =null;


    public ArticleAdapter(List<Article_info> Article_info) {
        this.Article_info=Article_info;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

        viewHolder.tv_name.setText(Article_info.get(i).getName());
        viewHolder.tv_date.setText(Article_info.get(i).getCreate_at());
        viewHolder.tv_title.setText(Article_info.get(i).getTitle());
        viewHolder.tv_des.setText(Article_info.get(i).getDes());

    }


    @Override
    public int getItemCount() {
        return (Article_info == null) ? 0 : Article_info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_title, tv_date, tv_des;

        public ViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.name);
            tv_date = view.findViewById(R.id.date);
            tv_des = view.findViewById(R.id.desp);
            tv_title = view.findViewById(R.id.title_);
        }

    }


}
