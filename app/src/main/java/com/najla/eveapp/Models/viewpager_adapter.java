package com.najla.eveapp.Models;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.najla.eveapp.R;

public class viewpager_adapter  extends PagerAdapter {

   // private List<Adv> ADV_info =null;

    int photo[];

    public viewpager_adapter(int[] photo) {
        this.photo =photo;
    }

    @Override
    public int getCount() {
        return photo.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView image  = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.item_viewpager, container, false);
        image.setImageResource(photo[position]);
        container.addView(image);
        return image;
}

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
